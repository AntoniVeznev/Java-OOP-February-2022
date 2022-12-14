package Exams.E02JavaOOPExam_10April2021.P1StructureAndBusinessLogic.aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {

    private final static int START_FISH_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        setSize(getSize() + 3);
    }

    @Override
    public int getSize() {
        return START_FISH_SIZE;
    }
}
