
package Exercises.E01WorkingWithAbstraction.P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GreedyTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());

        String[] sequenceArr = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();

        long gold = 0;
        long stones = 0;
        long money = 0;

        for (int i = 0; i < sequenceArr.length; i += 2) {
            String name = sequenceArr[i];
            long count = Long.parseLong(sequenceArr[i + 1]);
            String typeOfItems = "";
            typeOfItems = checkTypeOfItems(name, typeOfItems);

            if (typeOfItems.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (typeOfItems) {
                case "Gem":
                    if (!bag.containsKey(typeOfItems)) {
                        if (bag.containsKey("Gold")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeOfItems).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(typeOfItems)) {
                        if (bag.containsKey("Gem")) {
                            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeOfItems).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }
            if (!bag.containsKey(typeOfItems)) {
                bag.put((typeOfItems), new LinkedHashMap<>());
            }
            if (!bag.get(typeOfItems).containsKey(name)) {
                bag.get(typeOfItems).put(name, 0L);
            }
            bag.get(typeOfItems).put(name, bag.get(typeOfItems).get(name) + count);

            if (typeOfItems.equals("Gold")) {
                gold += count;
            } else if (typeOfItems.equals("Gem")) {
                stones += count;
            } else if (typeOfItems.equals("Cash")) {
                money += count;
            }
        }
        for (var element : bag.entrySet()) {
            Long sumValues = element.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.printf("<%s> $%s%n", element.getKey(), sumValues);
            element.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static String checkTypeOfItems(String name, String typeOfItems) {
        if (name.length() == 3) {
            typeOfItems = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            typeOfItems = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            typeOfItems = "Gold";
        }
        return typeOfItems;
    }
}