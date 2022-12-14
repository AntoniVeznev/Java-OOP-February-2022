package Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {

    private Collection<Toy> toys;

    public ToyRepository() {
        toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {

        return toys.remove(toy);

    }

    @Override
    public Toy findFirst(String type) {
        for (Toy toy : toys) {
            if (toy.getClass().getSimpleName().equals(type)) {
                return toy;
            }
        }
        return null;
    }

    private Collection<Toy> getToys() {
        return toys;
    }

    private void setToys(Collection<Toy> toys) {
        this.toys = toys;
    }
}
