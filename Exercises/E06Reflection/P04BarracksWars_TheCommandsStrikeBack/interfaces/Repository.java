package Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

    void addUnit(Unit unit);

    String getStatistics();

    void removeUnit(String unitType);
}
