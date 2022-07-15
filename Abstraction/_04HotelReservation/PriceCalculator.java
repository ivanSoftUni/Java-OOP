package Abstraction._04HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Seasons seasons;
    private Discount discount;


    public PriceCalculator(double pricePerDay, int days, Seasons seasons, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.seasons = seasons;
        this.discount = discount;
    }

    public double calculatePrice() {
        return pricePerDay * days * seasons.getMultyplier() * discount.getDiscount();
    }


}
