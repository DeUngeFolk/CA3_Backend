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



}
