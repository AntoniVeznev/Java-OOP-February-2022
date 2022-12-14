package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}
