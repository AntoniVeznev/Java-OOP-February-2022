package Exercises.E05Polymorphism.P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class BaseVehicle implements Vehicles {
    private double quantity;
    private double consumption;
    private double tankCapacity;


    public BaseVehicle(double quantity, double consumption, double tankCapacity) {
        this.quantity = quantity;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {


        this.consumption = consumption;
    }

    public abstract void refueling(double liters);

    public String driving(double distance) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double fuelNeeded = distance * getConsumption();
        if (fuelNeeded <= getQuantity()) {
            setQuantity(getQuantity() - distance * getConsumption());
            return String.format("%s travelled %s km", getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
    }

    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getQuantity());
    }

}
