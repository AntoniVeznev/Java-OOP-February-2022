package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers;

import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.suitcases.Suitcase;

public interface Explorer {
    String getName();

    double getEnergy();

    boolean canSearch();

    Suitcase getSuitcase();

    void search();
}
