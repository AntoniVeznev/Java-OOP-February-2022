package Exercises.E05Polymorphism.P01Vehicles;

import java.text.DecimalFormat;

public class Car implements Vehicles {
    private double quantity;
    private double consumption;
    private static final double INCREASED_CONSUMPTION = 0.9;

    public Car(double quantity, double consumption) {
        this.quantity = quantity;
        setConsumption(consumption);
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
        this.consumption = consumption + INCREASED_CONSUMPTION;
    }

    @Override
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

    @Override
    public void refueling(double liters) {
        setQuantity(getQuantity() + liters);

    }

    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), quantity);
    }
}