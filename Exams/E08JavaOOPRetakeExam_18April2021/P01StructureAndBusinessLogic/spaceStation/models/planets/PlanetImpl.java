package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;


import java.util.Collection;
import java.util.LinkedList;

public class PlanetImpl implements Planet {

    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        setName(name);
        items = new LinkedList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }
}
