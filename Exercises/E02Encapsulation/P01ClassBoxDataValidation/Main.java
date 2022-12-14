package Exercises.E02Encapsulation.P01ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double l = Double.parseDouble(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        Box box = new Box(l, w, h);
        System.out.println(box.calculateSurfaceArea());
        System.out.println(box.calculateLateralSurfaceArea());
        System.out.println(box.calculateVolume());
    }
}
