package Labs.L01WorkingWithAbstraction;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        printUpperFigure(size);
        printBottomFigure(size);

    }

    private static void printBottomFigure(int size) {
        for (int i = size - 1; i >= 1; i--) {
            printFigure(size, i);
        }
    }

    private static void printUpperFigure(int size) {
        for (int i = 1; i <= size; i++) {
            printFigure(size, i);
        }
    }

    private static void printFigure(int size, int i) {
        for (int j = 0; j < size - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i - 1; j++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
