package Exercises.E01WorkingWithAbstraction.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        Card card = new Card(SuitPowers.valueOf(suit), RankPowers.valueOf(rank));

        System.out.printf("Card name: %s of %s; Card power: %d%n", card.getRankPowers(), card.getCardSuit(), card.getPower());

    }
}
