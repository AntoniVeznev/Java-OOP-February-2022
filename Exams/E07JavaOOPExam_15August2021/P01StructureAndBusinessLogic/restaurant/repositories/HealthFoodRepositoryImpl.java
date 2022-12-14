package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.repositories;

import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    private Map<String, HealthyFood> dataMap;

    public HealthFoodRepositoryImpl() {
        this.dataMap = new LinkedHashMap<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return dataMap.get(name);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(dataMap.values());
    }

    @Override
    public void add(HealthyFood entity) {
        dataMap.put(entity.getName(), entity);
    }
}
