package Exercises.E01WorkingWithAbstraction.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lightSignals = scanner.nextLine().split("\\s+");
        int numberOfChanges = Integer.parseInt(scanner.nextLine());
        List<Light> lightsList = new ArrayList<>();
        for (String color : lightSignals) {
            Light light = new Light(Color.valueOf(color));
            lightsList.add(light);
        }
        for (int i = 0; i < numberOfChanges; i++) {
            lightsList.forEach(light -> {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }
    }
}