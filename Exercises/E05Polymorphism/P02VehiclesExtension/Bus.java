package Exercises.E05Polymorphism.P02VehiclesExtension;

public class Bus extends BaseVehicle {
    private double INCREASED_CONSUMPTION_BUS = 1.4;

    public Bus(double quantity, double consumption, double tankCapacity) {
        super(quantity, consumption, tankCapacity);
        setConsumption(consumption + INCREASED_CONSUMPTION_BUS);
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
