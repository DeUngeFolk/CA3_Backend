package entities;


import dtos.AnimalTypeDTO;
import org.eclipse.persistence.internal.oxm.schema.model.All;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "AnimalType.deleteAllRows", query = "DELETE from AnimalType")
public class AnimalType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "animalType", cascade = CascadeType.MERGE )
    private List<AnimalFact> animalFacts = new ArrayList<>();

    public AnimalType() {
    }

    public AnimalType(AnimalTypeDTO animalTypeDTO) {

        long longId = animalTypeDTO.getId();
        this.id = longId;
        this.type = animalTypeDTO.getType();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // edit below here.
    private String type;


    public AnimalType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public AnimalType(String type) {
        type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public List<AnimalFact> getAnimalFacts() {
        return animalFacts;
    }

    public void setAnimalFacts(List<AnimalFact> animalFacts) {
        this.animalFacts = animalFacts;
    }

    public void addFact(AnimalFact animalFact) {

        animalFacts.add(animalFact);

    }
}
