package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.tables.interfaces;

import Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;

public interface Table {
    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();
}
