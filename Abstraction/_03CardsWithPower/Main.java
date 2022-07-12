package Abstraction._03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        CardRank cardRank = CardRank.valueOf(rank);
        Suit cardSuit = Suit.valueOf(suit);
        Card card = new Card(cardRank, cardSuit);


        System.out.println(card.toString());

    }
}
