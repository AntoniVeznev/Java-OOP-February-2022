package Exams.E08JavaOOPRetakeExam_18April2021.P01StructureAndBusinessLogic.spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class Backpack implements Bag {

    private Collection<String> items;

    public Backpack() {
        this.items = new LinkedList<>();
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }
}
