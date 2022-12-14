package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.mission;

import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.suitcases.Carton;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.suitcases.Suitcase;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories.ExplorerRepository;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories.Repository;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
   //    State currentState = new StateImpl(state.getName());
   //    Carton carton = new Carton();
   //    Collection<String> baba = state.getExhibits();

   //    while (!baba.isEmpty())
   //        for (Explorer explorer : explorers) {
   //            while (explorer.canSearch()) {
   //                explorer.search();
   //                explorer.getSuitcase().getExhibits().add()

   //            }
   //        }
    }
}