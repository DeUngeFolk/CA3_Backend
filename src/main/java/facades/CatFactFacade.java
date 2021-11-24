package facades;

import dtos.AnimalFactDTO;
import dtos.CatFactDTO;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;
import java.util.concurrent.ExecutionException;

public class CatFactFacade {

    private static CatFactFacade instance;
    private static EntityManagerFactory emf;

    private CatFactFacade() {

    }

    public static CatFactFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CatFactFacade();
        }
        return instance;
    }

    public AnimalFactDTO getCatFact() throws ExecutionException, InterruptedException {

        return HttpUtils.FetchSwitch("catFactDTO");
    }

}
