package Labs.L04InterfacesAndAbstraction.P06Ferrari;

public class Ferrari implements Car {

    private String driverName;
    private static final String model = "488-Spider";
    private static final String useBreaks = "Brakes!";
    private static final String gasPedal = "brum-brum-brum-brrrrr";

    public Ferrari(String driverName) {
        this.driverName = driverName;

    }


    @Override
    public String brakes() {
        return useBreaks;
    }

    @Override
    public String gas() {
        return gasPedal;
    }

    public String toString() {
        return String.format("%s/%s/%s/%s", model, brakes(), gas(), driverName);
    }
}
