package Exercises.E01WorkingWithAbstraction.P03CardsWithPower;

public enum SuitPowers {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    public int power;

    public int getPower() {
        return power;
    }

    SuitPowers(int power) {
        this.power = power;
    }
}
