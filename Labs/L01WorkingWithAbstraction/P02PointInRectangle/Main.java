package Labs.L01WorkingWithAbstraction.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = numberArr[0];
        int bottomLeftY = numberArr[1];
        int topRightX = numberArr[2];
        int topRightY = numberArr[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int integerN = Integer.parseInt(scanner.nextLine());

        for (int lines = 1; lines <= integerN; lines++) {
            int[] coordinatesOfPointsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int firstCoordinateOfPoint = coordinatesOfPointsArr[0];
            int secondCoordinateOfPoint = coordinatesOfPointsArr[1];
            Point current = new Point(firstCoordinateOfPoint, secondCoordinateOfPoint);
            System.out.println(rectangle.contains(current));
        }
    }
}