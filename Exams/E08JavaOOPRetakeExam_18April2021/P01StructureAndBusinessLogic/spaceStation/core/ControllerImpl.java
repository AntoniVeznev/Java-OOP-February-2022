package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.core;

import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.common.ConstantMessages;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.common.ExceptionMessages;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts.Astronaut;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts.Biologist;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts.Geodesist;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts.Meteorologist;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.mission.Mission;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.mission.MissionImpl;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.planets.Planet;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.planets.PlanetImpl;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.repositories.AstronautRepository;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.repositories.PlanetRepository;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private PlanetRepository planetRepository;
    private AstronautRepository astronautRepository;

    public ControllerImpl() {
        this.planetRepository = new PlanetRepository();
        this.astronautRepository = new AstronautRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.getModels().stream().filter(e -> e.getName().equals(astronautName)).findFirst().orElse(null);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }


    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        List<Astronaut> allSuitableAstronauts = astronautRepository.getModels().stream().filter(e -> e.getOxygen() > 60).collect(Collectors.toList());
        if (allSuitableAstronauts.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        mission.explore(planet, allSuitableAstronauts);
        int count = 0;
        for (Astronaut allSuitableAstronaut : allSuitableAstronauts) {
            if (allSuitableAstronaut.getOxygen() <= 0) {
                count++;
                astronautRepository.remove(allSuitableAstronaut);
            }
        }
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, count);
    }

    @Override
    public String report() {
        return null;
    }
}
