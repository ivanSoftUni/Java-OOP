package Abstraction._04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        Seasons seasons = Seasons.parse(data[2]);
        String discountType = data[3];
        Discount discount = Discount.parse(data[3]);
        try {
            PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, seasons, discount);
            System.out.printf("%.2f%n", calculator.calculatePrice());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
