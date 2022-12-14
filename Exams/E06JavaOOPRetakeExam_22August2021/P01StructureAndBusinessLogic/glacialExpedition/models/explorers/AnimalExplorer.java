package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{

    private static final int STARTING_ENERGY = 100;

    public AnimalExplorer(String name) {
        super(name, STARTING_ENERGY);
    }
}
