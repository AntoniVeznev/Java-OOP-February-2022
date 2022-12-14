package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {

    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(planets.values());
    }

    @Override
    public void add(Planet planet) {
        planets.put(planet.getName(), planet);
    }

    @Override
    public boolean remove(Planet planet) {
        boolean isPlanetInREPO = planets.containsValue(planet);
        if (isPlanetInREPO) {
            planets.remove(planet.getName());
            return true;
        }
        return false;
    }

    @Override
    public Planet findByName(String name) {
        return planets.get(name);
    }
}
