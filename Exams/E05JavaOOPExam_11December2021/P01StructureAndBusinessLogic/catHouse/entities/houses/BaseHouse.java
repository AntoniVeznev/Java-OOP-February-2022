package Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy : toys) {
            sum += toy.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
        if (capacity <= cats.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s:", name, this.getClass().getSimpleName())).append(System.lineSeparator());
        if (cats.isEmpty()) {
            builder.append("Cats: ");
            builder.append("none").append(System.lineSeparator());
        } else {
            builder.append("Cats: ");
            for (Cat cat : cats) {
                builder.append(cat.getName());
                builder.append(" ");
            }
            builder.append(System.lineSeparator());
        }


        builder.append(String.format("Toys: %d Softness: %d", getToys().size(), sumSoftness()));
        return builder.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    private int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setToys(Collection<Toy> toys) {
        this.toys = toys;
    }

    public void setCats(Collection<Cat> cats) {
        this.cats = cats;
    }

}
