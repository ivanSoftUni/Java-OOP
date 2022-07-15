
package Abstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < input.length; i += 2) {
            String treasureName = input[i];
            long treasureQuantity = Long.parseLong(input[i + 1]);

            String currentTreasureName = "";

            if (treasureName.length() == 3) {
                currentTreasureName = "Cash";
            } else if (treasureName.toLowerCase().endsWith("gem")) {
                currentTreasureName = "Gem";
            } else if (treasureName.toLowerCase().equals("gold")) {
                currentTreasureName = "Gold";
            }

            if (currentTreasureName.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + treasureQuantity) {
                continue;
            }

            switch (currentTreasureName) {
                case "Gem":
                    if (!bag.containsKey(currentTreasureName)) {
                        if (bag.containsKey("Gold")) {
                            if (treasureQuantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentTreasureName).values().stream().mapToLong(e -> e).sum() + treasureQuantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(currentTreasureName)) {
                        if (bag.containsKey("Gem")) {
                            if (treasureQuantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentTreasureName).values().stream().mapToLong(e -> e).sum() + treasureQuantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(currentTreasureName)) {
                bag.put((currentTreasureName), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(currentTreasureName).containsKey(treasureName)) {
                bag.get(currentTreasureName).put(treasureName, 0L);
            }


            bag.get(currentTreasureName).put(treasureName, bag.get(currentTreasureName).get(treasureName) + treasureQuantity);
            if (currentTreasureName.equals("Gold")) {
                gold += treasureQuantity;
            } else if (currentTreasureName.equals("Gem")) {
                gems += treasureQuantity;
            } else if (currentTreasureName.equals("Cash")) {
                cash += treasureQuantity;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}