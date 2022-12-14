package Exercises.E06Reflection.P03BarracksWars_ANewFactory;


import Exercises.E06Reflection.P03BarracksWars_ANewFactory.core.Engine;
import Exercises.E06Reflection.P03BarracksWars_ANewFactory.core.factories.UnitFactoryImpl;
import Exercises.E06Reflection.P03BarracksWars_ANewFactory.data.UnitRepository;
import Exercises.E06Reflection.P03BarracksWars_ANewFactory.interfaces.Repository;
import Exercises.E06Reflection.P03BarracksWars_ANewFactory.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
