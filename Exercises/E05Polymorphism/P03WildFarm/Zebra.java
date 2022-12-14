package Exercises.E05Polymorphism.P03WildFarm;

public class Zebra extends Mammal {


    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(food.getQuantity());
        }
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }
}

