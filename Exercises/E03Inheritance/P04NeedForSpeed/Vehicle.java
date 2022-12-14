package Exercises.E03Inheritance.P04NeedForSpeed;

public class Vehicle {
    public static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    public double fuelConsumption;
    public double fuel;
    public int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double costToDrive = kilometers * this.getFuelConsumption();
        if (this.getFuel() >= costToDrive) {
            this.setFuel(this.getFuel() - costToDrive);
        }
    }
}