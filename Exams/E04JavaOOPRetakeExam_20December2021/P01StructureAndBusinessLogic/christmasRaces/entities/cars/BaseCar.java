package Exams.E04JavaOOPRetakeExam_20December2021.P01StructureAndBusinessLogic.christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        setCubicCentimeters(cubicCentimeters);
    }

    private void setModel(String model) {
        if (model == null || model.trim().length() < 4) {
            String massage = String.format(ExceptionMessages.INVALID_MODEL, model, 4);
            throw new IllegalArgumentException(massage);
        }
        this.model = model;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setHorsePower(int horsePower) {
        checkHP(horsePower);
        this.horsePower = horsePower;
    }

    protected abstract void checkHP(int horsePower);
}