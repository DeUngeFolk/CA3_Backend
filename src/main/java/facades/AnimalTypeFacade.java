package facades;

import dtos.AnimalTypeDTO;
import entities.AnimalType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class AnimalTypeFacade {

    private static AnimalTypeFacade instance;
    private static EntityManagerFactory emf;

    private AnimalTypeFacade() {
    }


    public static AnimalTypeFacade getFacadeExample(EntityManagerFactory _emf) {

        if (instance == null) {
            emf = _emf;
            instance = new AnimalTypeFacade();
        }
        return instance;


    }

    public AnimalTypeDTO getById(long id) {
        EntityManager em = emf.createEntityManager();
        return new AnimalTypeDTO(em.find(AnimalType.class, id));

    }

    public AnimalTypeDTO getByType(String type) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<AnimalType> query = em.createQuery("SELECT a FROM AnimalType a WHERE a.type = :type", AnimalType.class);
        query.setParameter("type", type);
        AnimalType animalType = query.getSingleResult();
        AnimalTypeDTO animalTypeDTO = new AnimalTypeDTO(animalType);


        return animalTypeDTO;
    }


}
