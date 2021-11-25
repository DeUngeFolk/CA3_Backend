package dtos;

import entities.AnimalFact;

public class AnimalFactDTO {

    private int id;
    private AnimalTypeDTO Type;
    private String fact;

    public AnimalFactDTO(AnimalFact animalFact) {

        if (animalFact.getId() != null)
            this.id = animalFact.getId().intValue();
        Type = new AnimalTypeDTO(animalFact.getAnimalType());
        this.fact = animalFact.getFact();
    }

    public AnimalFactDTO(AnimalTypeDTO type, String fact) {
        Type = type;
        this.fact = fact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimalTypeDTO getType() {
        return Type;
    }

    public void setType(AnimalTypeDTO type) {
        Type = type;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
