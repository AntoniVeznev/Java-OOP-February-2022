package Exams.E02JavaOOPExam_10April2021.P1StructureAndBusinessLogic.aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    private final static int START_FISH_SIZE = 5;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        setSize(getSize() + 2);
    }

    @Override
    public int getSize() {
        return START_FISH_SIZE;
    }
}
