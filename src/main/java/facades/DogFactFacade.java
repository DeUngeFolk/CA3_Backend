package facades;

import dtos.AnimalFactDTO;
import dtos.CatFactDTO;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;
import java.util.concurrent.ExecutionException;

public class DogFactFacade {

    private static DogFactFacade instance;
    private static AnimalTypeFacade animalTypeFacade;
    private static EntityManagerFactory emf;

    private DogFactFacade() {

    }

    public static DogFactFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DogFactFacade();
        }
        return instance;
    }

    public AnimalFactDTO getDogFact() throws ExecutionException, InterruptedException {

        return HttpUtils.FetchSwitch("dogFactDTO");
    }



}