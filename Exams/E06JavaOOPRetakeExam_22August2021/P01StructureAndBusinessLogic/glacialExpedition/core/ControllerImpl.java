package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.core;

import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.common.ConstantMessages;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.common.ExceptionMessages;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers.AnimalExplorer;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers.Explorer;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers.GlacierExplorer;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers.NaturalExplorer;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.states.State;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.states.StateImpl;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories.ExplorerRepository;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories.Repository;
import Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories.StateRepository;

public class ControllerImpl implements Controller {
    ExplorerRepository explorerRepository = new ExplorerRepository();
    StateRepository stateRepository = new StateRepository();

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);

                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);

    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);


    }

    @Override
    public String retireExplorer(String explorerName) {
       Explorer explorer;
        for (Explorer explorer1 : explorerRepository.getCollection()) {
            if (explorer1.getName().equals(explorerName)){
                explorer=explorer1;
                explorerRepository.remove(explorer1);
                return String.format(ConstantMessages.EXPLORER_RETIRED,explorerName);
            }
        }
      return String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        return null;
    }

    @Override
    public String finalResult() {
        return null;
    }
}
