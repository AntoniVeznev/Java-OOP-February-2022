package Exercises.E05Polymorphism.P01Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split("\\s+");
        String[] secondArr = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(firstArr[1]), Double.parseDouble(firstArr[2]));
        Truck truck = new Truck(Double.parseDouble(secondArr[1]), Double.parseDouble(secondArr[2]));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {

            String[] commandArr = scanner.nextLine().split("\\s+");
            String command = commandArr[0];
            String typeOfVehicle = commandArr[1];
            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commandArr[2]);
                    if (typeOfVehicle.equals("Car")) {
                        System.out.println(car.driving(distance));
                    } else {
                        System.out.println(truck.driving(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commandArr[2]);
                    if (typeOfVehicle.equals("Car")) {
                        car.refueling(liters);
                    } else {
                        truck.refueling(liters);
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}