package Exercises.E05Polymorphism.P03WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %s]",
                getAnimalType(),
                getAnimalName(),
                getBreed(),
                decimalFormat.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }

    public String getBreed() {
        return breed;
    }

}
