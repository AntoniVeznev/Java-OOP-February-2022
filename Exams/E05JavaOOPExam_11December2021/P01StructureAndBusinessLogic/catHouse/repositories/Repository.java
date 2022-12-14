package Exams.E05JavaOOPExam_11December2021.P01StructureAndBusinessLogic.catHouse.repositories;

import catHouse.entities.toys.Toy;

public interface Repository {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
