package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getModels();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
