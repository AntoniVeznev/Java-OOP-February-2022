package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.models;

import java.util.Collection;

public interface Helper {
    void work();

    void addInstrument(Instrument instrument);

    boolean canWork();

    String getName();

    int getEnergy();

    Collection<Instrument> getInstruments();
}
