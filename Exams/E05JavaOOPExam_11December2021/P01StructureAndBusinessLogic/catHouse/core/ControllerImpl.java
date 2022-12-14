package Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.core;

import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.common.ConstantMessages;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.common.ExceptionMessages;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.cat.BaseCat;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.cat.Cat;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.cat.LonghairCat;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.cat.ShorthairCat;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.houses.BaseHouse;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.houses.House;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.houses.LongHouse;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.houses.ShortHouse;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.toys.Ball;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.toys.BaseToy;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.toys.Mouse;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.entities.toys.Toy;
import Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        houses = new ArrayList<>();
        toys = new ToyRepository();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        House house1 = null;
        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        } else {
            for (House house : houses) {
                if (house.getName().equals(houseName)) {
                    house1 = house;
                }
            }
            house1.buyToy(toy);
            toys.removeToy(toy);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
        }

    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        for (House house : houses) {
            if (catType.equals("LonghairCat") && house.getClass().getSimpleName().equals("LongHouse")) {
                house.addCat(cat);
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
            }
            if (catType.equals("ShorthairCat") && house.getClass().getSimpleName().equals("ShortHouse")) {
                house.addCat(cat);
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
            }
        }
        return ConstantMessages.UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        int countCatsEating = 0;
        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                for (Cat cat : house.getCats()) {
                    cat.eating();
                    countCatsEating += 1;
                }
            }
        }
        return String.format(ConstantMessages.FEEDING_CAT, countCatsEating);
    }

    @Override
    public String sumOfAll(String houseName) {
        double totalCatPrice = 0;
        double totalToyPrice = 0;
        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                for (Cat cat : house.getCats()) {
                    totalCatPrice += cat.getPrice();
                }
                for (Toy toy : house.getToys()) {
                    totalToyPrice += toy.getPrice();
                }
            }
        }
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalCatPrice + totalToyPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (House house : houses) {
            builder.append(house.getStatistics()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    private ToyRepository getToys() {
        return toys;
    }

    private void setToys(ToyRepository toys) {
        this.toys = toys;
    }

    public Collection<House> getHouses() {
        return houses;
    }

    public void setHouses(Collection<House> houses) {
        this.houses = houses;
    }
}
