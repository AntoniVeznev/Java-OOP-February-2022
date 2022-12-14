package Labs.L01WorkingWithAbstraction.P04HotelReservation;

public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    public int discount;

    DiscountType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

}