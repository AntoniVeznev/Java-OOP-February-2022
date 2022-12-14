package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.models;

public class Sleepy extends BaseHelper {
    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {

        if ((getEnergy() - 15) < 0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - 15);
        }
    }
}
