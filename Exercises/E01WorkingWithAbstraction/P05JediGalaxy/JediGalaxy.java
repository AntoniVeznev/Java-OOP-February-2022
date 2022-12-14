package Exercises.E01WorkingWithAbstraction.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class JediGalaxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = inputArr[0];
        int cols = inputArr[1];
        int value = 0;
        long allStars = 0;

        int[][] matrix = new int[rows][cols];

        fillTheMatrix(rows, cols, matrix, value);

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] petersRowAndColArr = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilsPowerCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilsPowerCoordinates[0];
            int evilCol = evilsPowerCoordinates[1];
            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow < matrix.length && evilCol < matrix[0].length) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }
            int peterRow = petersRowAndColArr[0];
            int peterCol = petersRowAndColArr[1];
            while (peterRow >= 0 && peterCol < matrix[1].length) {
                if (peterRow < matrix.length && peterCol >= 0 && peterCol < matrix[0].length) {
                    allStars += matrix[peterRow][peterCol];
                }
                peterCol++;
                peterRow--;
            }
            command = scanner.nextLine();
        }
        System.out.println(allStars);
    }

    private static void fillTheMatrix(int rows, int cols, int[][] matrix, int value) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value++;
            }
        }
    }
}