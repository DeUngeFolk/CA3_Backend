package facades;

import dtos.AnimalFactDTO;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;
import java.util.concurrent.ExecutionException;


public class FoxFactFacade {
    private static FoxFactFacade instance;
    private static AnimalTypeFacade animalTypeFacade;
    private static EntityManagerFactory emf;


    private FoxFactFacade() {

    }

    public static FoxFactFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FoxFactFacade();
        }
        return instance;
    }

    public AnimalFactDTO getFoxFact() throws ExecutionException, InterruptedException {

        return HttpUtils.FetchSwitch("foxFactDTO");
    }

}
