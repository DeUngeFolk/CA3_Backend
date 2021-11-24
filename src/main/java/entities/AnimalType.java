package entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "AnimalType.deleteAllRows", query = "DELETE from AnimalType")
public class AnimalType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public AnimalType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // edit below here.
    private String Type;


    public AnimalType(Long id, String type) {
        this.id = id;
        Type = type;
    }

    public AnimalType(String type) {
        Type = type;
    }


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}