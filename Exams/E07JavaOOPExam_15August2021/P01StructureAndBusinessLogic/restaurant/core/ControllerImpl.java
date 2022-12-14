package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.core;

import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.common.ExceptionMessages;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;

import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.drinks.Fresh;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.drinks.Smoothie;

import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.healthyFoods.Salad;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.healthyFoods.VeganBiscuits;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.drinks.interfaces.Beverages;

import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.tables.InGarden;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.tables.Indoors;
import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;


import java.lang.management.OperatingSystemMXBean;
import java.util.Collection;


public class ControllerImpl implements Controller {


    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = null;
        if (type.equals("Salad")) {
            food = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
        }


        HealthyFood foodInRepository = healthFoodRepository.foodByName(name);
        if (foodInRepository == null) {
            healthFoodRepository.add(food);
            return String.format(OutputMessages.FOOD_ADDED, name);
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }


    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages baseBeverage = null;
        baseBeverage = type.equals("Fresh")
                ? new Fresh(name, counter, brand)
                : new Smoothie(name, counter, brand);

        Beverages ifRepoContainsThisDrink = beverageRepository.beverageByName(name, brand);

        if (ifRepoContainsThisDrink == null) {
            beverageRepository.add(baseBeverage);
            return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = type.equals("Indoors")
                ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        Table table1 = tableRepository.byNumber(tableNumber);

        if (table1 == null) {
            tableRepository.add(table);
            return String.format(OutputMessages.TABLE_ADDED, tableNumber);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));


    }

    @Override
    public String reserve(int numberOfPeople) {

        Collection<Table> tables = tableRepository.getAllEntities();
        Table table = tables
                .stream()
                .filter(e -> !e.isReservedTable() && e.getSize() == numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        HealthyFood food = null;
        food = healthFoodRepository.foodByName(healthyFoodName);

        Table table = null;
        table = tableRepository.byNumber(tableNumber);

        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }
        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);

    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Beverages beverages = null;
        beverages = beverageRepository.beverageByName(name, brand);
        Table table = null;
        table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        if (beverages == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }

        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);

    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = null;
        table = tableRepository.getAllEntities().stream().filter(e -> e.getTableNumber() == tableNumber).findFirst().orElse(null);

        double total = table.bill();
        table.clear();
        return String.format(OutputMessages.BILL,tableNumber,total);
    }


    @Override
    public String totalMoney() {
        StringBuilder builder= new StringBuilder();
        for (Table entity : tableRepository.getAllEntities()) {
            builder.append(entity.tableInformation());
        }
        return builder.toString().trim();
    }
}
