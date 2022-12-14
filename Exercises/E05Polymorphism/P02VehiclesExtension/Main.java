package Exercises.E05Polymorphism.P02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicleDetails1 = scanner.nextLine().split("\\s+");
        String[] vehicleDetails2 = scanner.nextLine().split("\\s+");
        String[] vehicleDetails3 = scanner.nextLine().split("\\s+");

        Vehicles car = new Car(Double.parseDouble(vehicleDetails1[1]), Double.parseDouble(vehicleDetails1[2]), Double.parseDouble(vehicleDetails1[3]));
        Vehicles truck = new Truck(Double.parseDouble(vehicleDetails2[1]), Double.parseDouble(vehicleDetails2[2]), Double.parseDouble(vehicleDetails2[3]));
        Vehicles bus = new Bus(Double.parseDouble(vehicleDetails3[1]), Double.parseDouble(vehicleDetails3[2]), Double.parseDouble(vehicleDetails3[3]));


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");

            String command = commandArr[0];
            String typeOfVehicle = commandArr[1];
            double number = Double.parseDouble(commandArr[2]);

            if (number <= 0) {
                System.out.println("Fuel must be a positive number");
                continue;
            }

            switch (command) {
                case "Drive":
                    if (typeOfVehicle.equals("Car")) {
                        System.out.println(car.driving(number));
                    } else if (typeOfVehicle.equals("Truck")) {
                        System.out.println(truck.driving(number));
                    } else if (typeOfVehicle.equals("Bus")) {
                        System.out.println(bus.driving(number));
                    } else if (typeOfVehicle.equals("Empty")) {
                        System.out.println(bus.driving(number));
                    }
                    break;
                case "Refuel":
                    if (typeOfVehicle.equals("Car")) {
                        car.refueling(number);
                    } else if (typeOfVehicle.equals("Truck")) {
                        truck.refueling(number);
                    } else if (typeOfVehicle.equals("Bus")) {
                        bus.refueling(number);
                    } else if (typeOfVehicle.equals("Empty")) {
                        bus.refueling(number);
                    }
                    break;
                case "DriveEmpty":
                    if (typeOfVehicle.equals("Bus")) {
                        System.out.println(bus.driving(number));
                    }
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}