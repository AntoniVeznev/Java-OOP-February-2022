package Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.toys;

public abstract class BaseToy implements Toy {

    private int softness;
    private double price;

    public BaseToy(int softness, double price) {
        this.softness = softness;
        this.price = price;
    }

    @Override
    public int getSoftness() {
        return softness;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setSoftness(int softness) {
        this.softness = softness;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}
