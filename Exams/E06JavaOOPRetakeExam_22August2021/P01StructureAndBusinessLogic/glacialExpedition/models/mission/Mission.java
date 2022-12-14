package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.mission;

import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
