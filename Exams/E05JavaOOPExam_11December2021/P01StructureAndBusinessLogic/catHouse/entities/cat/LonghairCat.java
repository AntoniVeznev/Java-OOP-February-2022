package Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private final static int KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 3);
    }
}
