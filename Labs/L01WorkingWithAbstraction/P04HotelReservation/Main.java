package Labs.L01WorkingWithAbstraction.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(inputArr[0]);
        int numberOfDays = Integer.parseInt(inputArr[1]);
        Season season = Season.valueOf(inputArr[2]);
        DiscountType discountType = DiscountType.valueOf(inputArr[3]);

        double finalPrice = PriceCalculator.calculate(pricePerDay, numberOfDays, season, discountType);
        System.out.printf("%.2f", finalPrice);

    }
}
