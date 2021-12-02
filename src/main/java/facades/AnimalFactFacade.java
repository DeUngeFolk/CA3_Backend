package facades;

import dtos.AnimalFactDTO;
import dtos.AnimalTypeDTO;
import entities.AnimalFact;
import entities.User;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AnimalFactFacade {

    private static AnimalFactFacade instance;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static EntityManagerFactory emf;


    private AnimalFactFacade() {
    }


    public static AnimalFactFacade getFacadeExample(EntityManagerFactory _emf) {

        if (instance == null) {

            emf = _emf;
            instance = new AnimalFactFacade();

        }
        return instance;

    }

    public long getAnimalFactCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long animalFactCount = (long) em.createQuery("SELECT COUNT(af) FROM AnimalFact af").getSingleResult();
            return animalFactCount;
        } finally {
            em.close();
        }
    }

    public AnimalFactDTO getAnimalFact(String animal) throws ExecutionException, InterruptedException {
        return HttpUtils.FetchSwitch(animal);


    }

    public void addFactToHistory(String username, AnimalFactDTO animalFactDTO) {

        AnimalFact animalFact = new AnimalFact(animalFactDTO);
        User user = FACADE.getUser(username);
        user.addFactToHistory(animalFact);
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }

    public void addFactToSavedFacts(String username, AnimalFactDTO animalFactDTO) {
        AnimalFact animalFact = new AnimalFact(animalFactDTO);
        User user = FACADE.getUser(username);
        user.addFactToSavedFacts(animalFact);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }

    public List<AnimalFactDTO> getFactHistory(String username) {

        EntityManager em = emf.createEntityManager();

        try {


            Query query = em.createNativeQuery(
                    "SELECT ANIMALFACT.* FROM ANIMALFACT, Facthistory where Facthistory.user_name = "
                            + "'" + username + "' GROUP BY ID"
                    , AnimalFact.class);

            List<AnimalFact> factHistory = query.getResultList();
            List<AnimalFactDTO> animalFactDTOList = AnimalFactDTO.getDtos(factHistory);
            return animalFactDTOList;
        } finally {
            em.close();
        }


    }

    public List<AnimalFactDTO> getSavedFacts(String username) {

        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createNativeQuery("SELECT ANIMALFACT.* FROM ANIMALFACT, SavedFacts WHERE SavedFacts.user_name = "
                            + "'" + username + "' GROUP BY ID"
                    , AnimalFact.class);
            List<AnimalFact> savedFacts = query.getResultList();
            List<AnimalFactDTO> animalFactDTOList = AnimalFactDTO.getDtos(savedFacts);
            return animalFactDTOList;
        } finally {
            em.close();
        }
    }

}
