package Exercises.E05Polymorphism.P03WildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }


    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(food.getQuantity());
        }
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }


}
