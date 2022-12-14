package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.states;

import java.util.Collection;

public interface State {
    Collection<String> getExhibits();

    String getName();
}
