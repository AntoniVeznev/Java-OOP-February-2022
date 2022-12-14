package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.repositories;

import fairyShop.models.Helper;
import fairyShop.models.Present;

import java.util.*;

public class PresentRepository implements Repository<Present> {

    private Map<String, Present> presents;

    public PresentRepository() {
        this.presents = new LinkedHashMap<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents.values());
    }

    @Override
    public void add(Present present) {
        presents.put(present.getName(), present);
    }

    @Override
    public boolean remove(Present present) {
        Present present1 = presents.get(present.getName());
        if (present1 != null) {
            presents.remove(present1.getName());
            return true;
        }
        return false;
    }

    @Override
    public Present findByName(String name) {
        Present present = presents.get(name);
        if (present != null) {
            return present;
        }
        return null;
    }
}
