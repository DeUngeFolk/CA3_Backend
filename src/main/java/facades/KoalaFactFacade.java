package facades;

import dtos.AnimalFactDTO;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;
import java.util.concurrent.ExecutionException;

public class KoalaFactFacade {

    private static KoalaFactFacade instance;
    private static AnimalTypeFacade animalTypeFacade;
    private static EntityManagerFactory emf;

    public KoalaFactFacade() {
    }

    public static KoalaFactFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new KoalaFactFacade();
        }
        return instance;
    }

    public AnimalFactDTO getKoalaFact() throws ExecutionException, InterruptedException {

        return HttpUtils.FetchSwitch("koalaFactDTO");
    }



}
