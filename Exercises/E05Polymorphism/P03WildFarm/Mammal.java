package Exercises.E05Polymorphism.P03WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s]",
                getAnimalType(),
                getAnimalName(),
                decimalFormat.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}
