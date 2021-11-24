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
}
