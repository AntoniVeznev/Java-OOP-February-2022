package Exams.E02JavaOOPExam_10April2021.P1StructureAndBusinessLogic.aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class DecorationRepository implements Repository {

    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = Collections.unmodifiableCollection(new LinkedList<>());
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        boolean isItContains = decorations.contains(decoration);
        if (isItContains) {
            decorations.remove(decoration);
            return true;
        }
        return false;
    }

    @Override
    public Decoration findByType(String type) {
        Decoration decoration = decorations.stream().filter(e -> e.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
        if (decoration == null) {
            return null;
        }
        return decoration;
    }
}
