package Labs.L04InterfacesAndAbstraction.P02CarShopExtended;

public class Seat extends CarImpl implements Sellable {
    private Double getPrice;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double getPrice) {
        super(model, color, horsePower, countryProduced);
        this.getPrice = getPrice;
    }

    @Override
    public Double getPrice() {
        return this.getPrice;
    }
}