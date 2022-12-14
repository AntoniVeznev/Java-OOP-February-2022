package Exams.E02JavaOOPExam_10April2021.P1StructureAndBusinessLogic.aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fishes;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        decorations = new ArrayList<>();
        fishes = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }



    @Override
    public int calculateComfort() {
        int sumDecorComfort = 0;
        for (Decoration decoration : decorations) {
            sumDecorComfort += decoration.getComfort();
        }
        return sumDecorComfort;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (capacity > getFish().size()) {
            fishes.add(fish);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        fishes.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : fishes) {
            fish.eat();
        }
    }

    @Override
    public Collection<Fish> getFish() {
        return fishes;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s (%s):", name, name.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append("Fish: ");
        if (getFish().isEmpty()) {
            builder.append("none");
        } else {
            for (Fish fish : fishes) {
                builder.append(String.join(" ", fish.getName()));
            }
        }
        builder.append(String.format("Decorations: %d", getDecorations().size())).append(System.lineSeparator());
        builder.append(String.format("Comfort: %d", calculateComfort()));
        return builder.toString();
    }
}
