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
}
