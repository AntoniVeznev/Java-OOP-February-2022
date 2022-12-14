package Exercises.E05Polymorphism.P03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = "";
        String name = "";
        Double weight = 0.0;
        String region = "";
        String breed = "";
        String food = "";
        Integer quantity = 0;
        int count = 0;
        List<Animal> animals = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.length() == 0) {
                break;
            }
            String[] array = input.split("\\s+");
            count++;
            if (count % 2 != 0) {
                type = array[0];
                name = array[1];
                weight = Double.parseDouble(array[2]);
                region = array[3];
                if (array.length == 5) {
                    breed = array[4];
                }
            } else {
                food = array[0];
                quantity = Integer.parseInt(array[1]);
            }
            if (count % 2 == 0) {
                switch (type) {
                    case "Mouse":
                        Animal mouse = new Mouse(name, type, weight, region);
                        mouse.makeSound();
                        if (food.equals("Vegetable")) {
                            mouse.eat(new Vegetable(quantity));
                        } else {
                            System.out.println("Mice are not eating that type of food!");
                        }
                        animals.add(mouse);
                        break;
                    case "Zebra":
                        Animal zebra = new Zebra(name, type, weight, region);
                        zebra.makeSound();
                        if (food.equals("Vegetable")) {
                            zebra.eat(new Vegetable(quantity));
                        } else {
                            System.out.println("Zebras are not eating that type of food!");
                        }
                        animals.add(zebra);
                        break;
                    case "Tiger":
                        Animal tiger = new Tiger(name, type, weight, region);
                        tiger.makeSound();
                        if (food.equals("Meat")) {
                            tiger.eat(new Meat(quantity));
                        } else {
                            System.out.println("Tigers are not eating that type of food!");
                        }
                        animals.add(tiger);
                        break;
                    case "Cat":
                        Animal cat = new Cat(name, type, weight, region, breed);
                        cat.makeSound();
                        if (food.equals("Meat")) {
                            cat.eat(new Meat(quantity));
                        } else {
                            cat.eat(new Vegetable(quantity));
                        }
                        animals.add(cat);

                        break;

                }
            }
            input = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}