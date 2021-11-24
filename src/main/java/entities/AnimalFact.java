package entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Animal.deleteAllRows", query = "DELETE FROM AnimalFact ")
public class AnimalFact implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AnimalFact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Edit below here

    private String fact;


    @ManyToOne
    private AnimalType animalType;

    public AnimalFact(String fact) {
        this.fact = fact;
        this.animalType = getAnimalType();
    }


    public AnimalFact(Long id, String fact, AnimalType animalType) {
        this.id = id;
        this.fact = fact;
        this.animalType = animalType;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }
}
