package Abstraction._02CardRank;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Card Ranks:%n");
        Arrays.stream(CardRanks.values())
                .forEach(cardRanks -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardRanks.ordinal(), cardRanks.name()));

    }
}
