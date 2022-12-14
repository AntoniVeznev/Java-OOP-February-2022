package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper {


    private String name;
    private int energy;
    private Collection<Instrument> instruments;


    public BaseHelper(String name, int energy) {
        setName(name);
        setEnergy(energy);
        instruments = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

        @Override
        public void work() {

            if ((getEnergy() - 10) < 0) {
                setEnergy(0);
            } else {
                setEnergy(getEnergy() - 10);
            }
        }

    @Override
    public void addInstrument(Instrument instrument) {
        getInstruments().add(instrument);
    }

    @Override
    public boolean canWork() {
        if (getEnergy() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }
}
