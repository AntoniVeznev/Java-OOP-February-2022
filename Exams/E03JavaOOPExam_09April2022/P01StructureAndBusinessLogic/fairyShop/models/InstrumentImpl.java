package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    protected void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        if ((getPower() - 10) < 0) {
            setPower(0);
        } else {
            setPower(getPower() - 10);
        }
    }

    @Override
    public boolean isBroken() {
        if (getPower() == 0) {
            return true;
        }
        return false;
    }
}
