package Exercises.E01WorkingWithAbstraction.P03CardsWithPower;

public class Card {
    private SuitPowers cardSuit;
    private RankPowers rankPowers;
    private int power;

    public SuitPowers getCardSuit() {
        return cardSuit;
    }

    public int getPower() {
        return rankPowers.getPower() + cardSuit.getPower();
    }

    public RankPowers getRankPowers() {
        return rankPowers;
    }

    public Card(SuitPowers cardSuit, RankPowers rankPowers) {
        this.cardSuit = cardSuit;
        this.rankPowers = rankPowers;
    }
}
