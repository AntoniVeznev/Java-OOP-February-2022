package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces;

import christmasRaces.core.ControllerImpl;
import christmasRaces.core.EngineImpl;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.races.Race;
import christmasRaces.io.ConsoleReader;
import christmasRaces.io.ConsoleWriter;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.CarRepository;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.DriverRepository;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.RaceRepository;
import Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> driverRepository = new DriverRepository();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
