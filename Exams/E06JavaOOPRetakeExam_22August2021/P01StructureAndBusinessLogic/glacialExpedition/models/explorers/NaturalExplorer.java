package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final int STARTING_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, STARTING_ENERGY);
    }

    @Override
    public void search() {
        double currentEnergy = getEnergy() - 7;
        if (currentEnergy >= 0) {
            setEnergy(getEnergy() - 7);
        } else if (currentEnergy < 0) {
            setEnergy(0);
        }
    }
}
