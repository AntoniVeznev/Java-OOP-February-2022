package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
