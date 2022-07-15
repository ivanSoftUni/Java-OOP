package Abstraction._04HotelReservation;

public enum Discount {
    VIP(0.8),
    Second_Visit(0.9),
    None(1);


    private double discount;

    Discount(double discount) {
        this.discount = discount;
    }


    public double getDiscount() {
        return discount;
    }

    public static Discount parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return Second_Visit;
            case "None":
                return None;
            default:
                throw new IllegalArgumentException("Unknown enum value" + str);
        }
    }

}
