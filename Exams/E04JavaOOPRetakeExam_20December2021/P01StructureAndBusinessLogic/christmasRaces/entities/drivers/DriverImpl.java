package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.drivers;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 5) {
            String massage = String.format(ExceptionMessages.INVALID_NAME, name, 5);
            throw new IllegalArgumentException(massage);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
        }
        this.car = car;
    }

    private void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    @Override
    public void winRace() {
        setNumberOfWins(numberOfWins++);
    }

    @Override
    public boolean getCanParticipate() {
        return car != null;

    }
}
