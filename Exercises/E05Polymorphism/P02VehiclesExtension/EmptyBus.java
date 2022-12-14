package Exercises.E05Polymorphism.P02VehiclesExtension;

public class EmptyBus extends BaseVehicle {
    public EmptyBus(double quantity, double consumption, double tankCapacity) {
        super(quantity, consumption, tankCapacity);
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
