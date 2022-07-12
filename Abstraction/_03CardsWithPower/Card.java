package Abstraction._03CardsWithPower;

public class Card {
    private CardRank cardRank;
    private Suit cardSuit;

    public Card(CardRank cardRank, Suit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }


    public CardRank getCardRank() {
        return cardRank;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    private int calculatePower() {
        return cardRank.getValue() + cardSuit.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d%n", getCardRank(), getCardSuit(), calculatePower());
    }
}
