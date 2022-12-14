package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.core;

import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.common.ExceptionMessages;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.cars.Car;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.cars.MuscleCar;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.cars.SportsCar;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.drivers.Driver;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.drivers.DriverImpl;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.races.Race;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.races.RaceImpl;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.CarRepository;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.DriverRepository;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.RaceRepository;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    public Repository<Car> carRepository;
    public Repository<Driver> driverRepository;
    public Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver person = new DriverImpl(driver);
        for (Driver driver1 : driverRepository.getAll()) {
            if (driver1.getName().equals(person.getName())) {
                String massage = String.format(ExceptionMessages.DRIVER_EXISTS, person.getName());
                throw new IllegalArgumentException(massage);
            }
        }
        driverRepository.add(person);
        return String.format(OutputMessages.DRIVER_CREATED, person.getName());
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                for (Car car1 : carRepository.getAll()) {
                    if (car1.equals(car)) {
                        String massage = String.format(ExceptionMessages.CAR_EXISTS, model);
                        throw new IllegalArgumentException(massage);
                    }
                }
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                for (Car car1 : carRepository.getAll()) {
                    if (car1.equals(car)) {
                        String massage = String.format(ExceptionMessages.CAR_EXISTS, model);
                        throw new IllegalArgumentException(massage);
                    }
                }
                break;
        }
        carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driverRepository.getByName(driverName) == null) {
            String massage = String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName);
            throw new IllegalArgumentException(massage);
        }
        Car car = carRepository.getByName(carModel);
        if (carRepository.getByName(carModel) == null) {
            String massage = String.format(ExceptionMessages.CAR_NOT_FOUND, carModel);
            throw new IllegalArgumentException(massage);
        }
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            String massage = String.format(ExceptionMessages.RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(massage);
        }
        if (driver == null) {
            String massage = String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName);
            throw new IllegalArgumentException(massage);
        }
        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            String massage = String.format(ExceptionMessages.RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(massage);
        }
        if (race.getDrivers().size() < 3) {
            String massage = String.format(ExceptionMessages.RACE_INVALID, raceName, 3);
            throw new IllegalArgumentException(massage);
        }
        Collection<Driver> drivers = race.getDrivers();
        List<Driver> winners = drivers
                .stream()
                .sorted((w1,w2)->Double.compare(w2.getCar().calculateRacePoints(race.getLaps()),w1.getCar().calculateRacePoints(race.getLaps()))).limit(3).collect(Collectors.toList());

        Driver first = winners.get(0);
        Driver second = winners.get(1);
        Driver third = winners.get(2);

        raceRepository.remove(race);

        StringBuilder builder = new StringBuilder();

        builder.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, first.getName(), raceName)).append(System.lineSeparator());
        builder.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, second.getName(), raceName)).append(System.lineSeparator());
        builder.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, third.getName(), raceName));
        return builder.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        for (Race race1 : raceRepository.getAll()) {
            if (race1.getName().equals(name)) {
                String massage = String.format(ExceptionMessages.RACE_EXISTS, name);
                throw new IllegalArgumentException(massage);
            }
        }
        raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
