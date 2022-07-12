package Abstraction._01CardSuit;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        Arrays.stream(Card.values()).forEach(card -> System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(),card.name()));

    }
}
