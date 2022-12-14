package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.cars;


import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar {

    private static final int CUBIC_CENTIMETERS = 5000;
    private static final int MINIMUM_HORSEPOWER = 400;
    private static final int MAXIMUM_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void checkHP(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER || horsePower > MAXIMUM_HORSEPOWER) {
            String message = String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower);
            throw new IllegalArgumentException(message);
        }
    }
}
