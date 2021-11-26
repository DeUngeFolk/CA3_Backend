package facades;

import dtos.AnimalFactDTO;
import entities.AnimalFact;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AnimalFactFacade {

    private static AnimalFactFacade instance;
    private static UserFacade userFacade;
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

    public void addFactToHistory(String username, AnimalFactDTO animalFactDTO) {

        AnimalFact animalFact = new AnimalFact(animalFactDTO);
        User user = new User(userFacade.getUser(username));
        user.addFactToHistory(animalFact);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }



    }

}
