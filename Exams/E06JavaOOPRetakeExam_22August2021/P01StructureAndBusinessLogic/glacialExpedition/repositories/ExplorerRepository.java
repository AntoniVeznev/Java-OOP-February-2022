package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExplorerRepository implements Repository<Explorer> {

    private Map<String, Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorers.values());
    }

    @Override
    public void add(Explorer explorer) {
        explorers.put(explorer.getName(), explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        if (explorers.containsKey(explorer.getName())) {
            explorers.remove(explorer.getName(), explorer);
            return true;
        }
        return false;
    }

    @Override
    public Explorer byName(String name) {
        Explorer explorer;
        if (explorers.containsKey(name)) {
            explorer = explorers.get(name);
            return explorer;
        }
        return null;
    }
}
