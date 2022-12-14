package Exercises.E06Reflection.P03BarracksWars_ANewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

    void addUnit(Unit unit);

    String getStatistics();

    void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
