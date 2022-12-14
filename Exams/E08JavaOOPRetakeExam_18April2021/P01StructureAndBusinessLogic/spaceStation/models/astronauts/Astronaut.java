package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts;

import spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
