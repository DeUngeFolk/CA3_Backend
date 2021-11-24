package dtos;

import entities.AnimalType;

public class AnimalTypeDTO {

    private int id;
    private String type;


    public AnimalTypeDTO(AnimalType animalType) {

        if (animalType.getId() != null)
            this.id = animalType.getId().intValue();

        this.type = animalType.getType();
    }

    public AnimalTypeDTO(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public AnimalTypeDTO(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
