package Exercises.E02Encapsulation.P04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies")
                || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            String massage = "Cannot place " + toppingType + " on top of your pizza.";
            throw new IllegalArgumentException(massage);
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String massage = toppingType + " weight should be in the range [1..50].";
            throw new IllegalArgumentException(massage);
        }
    }

    public double calculateCalories() {
        double modifier1 = 0;
        if (toppingType.equals("Meat")) {
            modifier1 = 1.2;
        } else if (toppingType.equals("Veggies")) {
            modifier1 = 0.8;
        } else if (toppingType.equals("Cheese")) {
            modifier1 = 1.1;
        } else {
            modifier1 = 0.9;
        }
        return (2 * weight) * modifier1;
    }
}