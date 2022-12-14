package Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.core.factories;


import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.interfaces.Unit;
import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
