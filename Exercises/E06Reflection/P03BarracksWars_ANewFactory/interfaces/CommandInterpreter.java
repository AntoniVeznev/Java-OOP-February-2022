package Exercises.E06Reflection.P03BarracksWars_ANewFactory.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
