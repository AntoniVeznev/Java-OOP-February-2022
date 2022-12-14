package Exercises.E05Polymorphism.P02VehiclesExtension;

public class Car extends BaseVehicle {
    private double INCREASED_CONSUMPTION_CAR = 0.9;

    public Car(double quantity, double consumption, double tankCapacity) {
        super(quantity, consumption, tankCapacity);
        setConsumption(consumption + INCREASED_CONSUMPTION_CAR);
    }

    @Override
    public void refueling(double liters) {
        if (getTankCapacity() < (getQuantity() + liters)) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setQuantity(getQuantity() + liters);
        }
    }
}