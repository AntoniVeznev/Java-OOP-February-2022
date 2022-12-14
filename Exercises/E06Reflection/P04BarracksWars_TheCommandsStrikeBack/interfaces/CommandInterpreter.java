package Exercises.E06Reflection.P04BarracksWars_TheCommandsStrikeBack.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
