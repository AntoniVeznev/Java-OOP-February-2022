package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

public class Carton implements Suitcase {

    Collection<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
