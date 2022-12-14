package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Map<Integer, Table> dataMap;

    public TableRepositoryImpl() {
        this.dataMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(dataMap.values());
    }

    @Override
    public void add(Table entity) {
        dataMap.put(entity.getTableNumber(), entity);
    }

    @Override
    public Table byNumber(int number) {
        return dataMap.get(number);
    }
}
