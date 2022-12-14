package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.mission;

import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.astronauts.Astronaut;
import Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        for (Astronaut astronaut : astronauts) {
            if (!astronaut.canBreath()) {
                continue;
            }
            for (String item : planet.getItems()) {
                if (astronaut.canBreath()) {
                    astronaut.breath();
                    astronaut.getBag().getItems().add(item);
                    planet.getItems().remove(item);
                } else {
                    break;
                }
            }
        }
    }
}
