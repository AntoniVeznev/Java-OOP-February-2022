package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private Map<String, Beverages> dataMap;

    public BeverageRepositoryImpl() {
        this.dataMap = new LinkedHashMap<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return dataMap.get(drinkName);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(dataMap.values());
    }

    @Override
    public void add(Beverages entity) {
        dataMap.put(entity.getName(), entity);
    }
}
