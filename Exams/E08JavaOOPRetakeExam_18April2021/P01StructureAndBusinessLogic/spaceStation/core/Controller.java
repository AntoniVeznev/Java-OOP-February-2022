package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.core;

public interface Controller {
    String addAstronaut(String type, String astronautName);

    String addPlanet(String planetName, String... items);

    String retireAstronaut(String astronautName);

    String explorePlanet(String planetName);

    String report();
}
