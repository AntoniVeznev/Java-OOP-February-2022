package Exercises.E05Polymorphism.P02VehiclesExtension;

public class Truck extends BaseVehicle {
    private double INCREASED_CONSUMPTION_TRUCK = 1.6;
    private double LOWER_WITH_95PERCENT = 0.95;

    public Truck(double quantity, double consumption, double tankCapacity) {
        super(quantity, consumption, tankCapacity);
        setConsumption(consumption + INCREASED_CONSUMPTION_TRUCK);
    }

    @Override
    public void refueling(double liters) {
        if (getTankCapacity() < getQuantity() + (liters * LOWER_WITH_95PERCENT)) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setQuantity(getQuantity() + (liters * LOWER_WITH_95PERCENT));
        }
    }
}