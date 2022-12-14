package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAllEntities();

    void add(T entity);

}
