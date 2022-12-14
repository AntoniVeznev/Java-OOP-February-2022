package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.repositories;

import fairyShop.models.Helper;
import fairyShop.models.Present;

import java.util.*;

public class HelperRepository implements Repository<Helper> {

    private Map<String, Helper> helpers;

    public HelperRepository() {
        this.helpers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers.values());
    }

    @Override
    public void add(Helper helper) {
        helpers.put(helper.getName(), helper);
    }

    @Override
    public boolean remove(Helper helper) {
        Helper helper1 = helpers.get(helper.getName());
        if (helper1 != null) {
            helpers.remove(helper1.getName());
            return true;
        }
        return false;
    }

    @Override
    public Helper findByName(String name) {
        Helper helper = helpers.get(name);
        if (helper != null) {
            return helper;
        }
        return null;
    }

}

