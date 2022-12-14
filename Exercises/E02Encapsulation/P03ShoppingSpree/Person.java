package Exercises.E02Encapsulation.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            this.money = money - product.getCost();
        } else {
            String exceptionText = getName() + " can't afford " + product.getName();
            throw new IllegalArgumentException(exceptionText);
        }
    }
}