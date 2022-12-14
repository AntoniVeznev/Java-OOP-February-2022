package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut> {

    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(astronauts.values());
    }

    @Override
    public void add(Astronaut astronaut) {
        astronauts.put(astronaut.getName(), astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        boolean isHeInTheMap = astronauts.containsValue(astronaut);
        if (isHeInTheMap) {
            astronauts.remove(astronaut.getName());
            return true;
        }
        return false;

    }

    @Override
    public Astronaut findByName(String name) {
        if (astronauts.containsKey(name)) {
            return astronauts.get(name);
        }
        return null;
    }
}
