package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.races;

import christmasRaces.common.ExceptionMessages;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.drivers.Driver;


import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 5) {
            String massage = String.format(ExceptionMessages.INVALID_NAME, name, 5);
            throw new IllegalArgumentException(massage);
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            String massage = String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, 1);
            throw new IllegalArgumentException(massage);
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        } else if (!driver.getCanParticipate()) {
            String massage = String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE, driver.getName());
            throw new IllegalArgumentException(massage);
        } else if (drivers.contains(driver)) {
            String massage = String.format(ExceptionMessages.DRIVER_ALREADY_ADDED, driver.getName(), getName());
            throw new IllegalArgumentException(massage);
        }
        drivers.add(driver);
    }
}
