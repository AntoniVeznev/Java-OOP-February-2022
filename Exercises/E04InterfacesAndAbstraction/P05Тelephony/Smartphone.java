package Exercises.E04InterfacesAndAbstraction.P05Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String element : numbers) {
            for (int i = 0; i < element.length(); i++) {
                char currentSymbol = element.charAt(i);
                if (!Character.isDigit(currentSymbol)) {
                    builder.append("Invalid number!").append(System.lineSeparator());
                    break;
                }
                if (i == element.length() - 1) {
                    builder.append(String.format("Calling... %s", element)).append(System.lineSeparator());
                }
            }

        }
        return builder.toString();
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String element : urls) {
            for (int i = 0; i < element.length(); i++) {
                char currentSymbol = element.charAt(i);
                if (Character.isDigit(currentSymbol)) {
                    builder.append("Invalid URL!").append(System.lineSeparator());
                    break;
                }
                if (i == element.length() - 1) {
                    builder.append(String.format("Browsing: %s!", element)).append(System.lineSeparator());
                }
            }

        }
        return builder.toString();
    }
}
