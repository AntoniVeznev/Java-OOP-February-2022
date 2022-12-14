package Exams.E06JavaOOPRetakeExam_22August2021.P01StructureAndBusinessLogic.glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StateRepository implements Repository<State> {

    private Map<String, State> states;

    public StateRepository() {
        this.states = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(states.values());
    }

    @Override
    public void add(State state) {
        states.put(state.getName(), state);
    }

    @Override
    public boolean remove(State state) {
        if (states.containsKey(state.getName())) {
            states.remove(state.getName(), state);
            return true;
        }
        return false;
    }

    @Override
    public State byName(String name) {
        State state;
        if (states.containsKey(name)) {
            state = states.get(name);
            return state;
        }
        return null;
    }
}
