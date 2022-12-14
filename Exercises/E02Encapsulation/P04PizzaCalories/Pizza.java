package Exercises.E02Encapsulation.P04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15 || name.length() < 1) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        } else {
            this.name = name;
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int count) {
        if (count >= 0 && count <= 10) {
            this.toppings = new ArrayList<>(count);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double sum = dough.calculateCalories();
        for (Topping topping : toppings) {
            sum += topping.calculateCalories();
        }
        return sum;
    }
}