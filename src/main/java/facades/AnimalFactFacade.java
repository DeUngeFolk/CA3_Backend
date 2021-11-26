package facades;

import dtos.AnimalFactDTO;
import entities.AnimalFact;
import entities.User;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AnimalFactFacade {

    private static AnimalFactFacade instance;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade FACADE =  UserFacade.getUserFacade(EMF);
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
        User user = new User(FACADE.getUser(username));
        user.addFactToHistory(animalFact);

        EntityManager em = emf.createEntityManager();

        System.out.println(user.toString());

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }



    }

}
