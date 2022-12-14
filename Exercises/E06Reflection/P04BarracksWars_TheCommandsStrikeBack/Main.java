package Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack;


import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.core.Engine;
import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.data.UnitRepository;
import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
