package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    public Biologist(String name) {
        super(name, 70);
    }



    @Override
    public void breath() {
        setOxygen(getOxygen() - 5);
    }
}
