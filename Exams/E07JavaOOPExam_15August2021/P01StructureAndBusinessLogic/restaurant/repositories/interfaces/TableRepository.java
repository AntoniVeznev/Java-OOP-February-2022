package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);
}
