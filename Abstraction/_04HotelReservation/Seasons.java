package Abstraction._04HotelReservation;

public enum Seasons {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multyplier;

    Seasons(int modifier) {
        this.multyplier = modifier;
    }

    public int getMultyplier() {
        return multyplier;
    }

    public static Seasons parse(String str){
      return Seasons.valueOf(str.toUpperCase());
    }
}
