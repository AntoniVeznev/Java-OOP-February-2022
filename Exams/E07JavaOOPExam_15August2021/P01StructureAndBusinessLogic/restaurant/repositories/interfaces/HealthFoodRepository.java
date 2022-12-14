package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.repositories.interfaces;

public interface HealthFoodRepository<T> extends Repository<T> {
    T foodByName(String name);
}
