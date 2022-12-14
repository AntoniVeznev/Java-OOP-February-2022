package Exams.E02JavaOOPExam_10April2021.P1StructureAndBusinessLogic.aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;

    private Collection<Aquarium> aquariums;


    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decoration;
        if (decorationType.equals("Ornament")) {
            decoration = new Ornament();
        } else if (decorationType.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
                decorations.remove(decoration);
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }


    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }
        Aquarium aquarium = aquariums.stream().filter(e -> e.getName().equals(aquariumName)).findFirst().orElse(null);
        if (fishType.equals("FreshwaterFish") && aquarium.getName().equals("FreshwaterAquarium")) {
            aquarium.addFish(fish);
        } else if (fishType.equals("SaltwaterFish") && aquarium.getName().equals("SaltwaterAquarium")) {
            aquarium.addFish(fish);
        } else {
            return ConstantMessages.WATER_NOT_SUITABLE;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        int countOfFeededFish = 0;
        Aquarium aquarium = aquariums.stream().filter(e -> e.getName().equals(aquariumName)).findFirst().orElse(null);
        if (!aquarium.getFish().isEmpty()) {
            for (Fish fish : aquarium.getFish()) {
                fish.eat();
                countOfFeededFish++;
            }
        }
        return String.format(ConstantMessages.FISH_FED, countOfFeededFish);
    }


    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(e -> e.getName().equals(aquariumName)).findFirst().orElse(null);
        double sum = 0;
        for (Fish fish : aquarium.getFish()) {
            sum += fish.getPrice();
        }
        for (Decoration decoration : aquarium.getDecorations()) {
            sum += decoration.getPrice();
        }
        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            builder.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
