package Labs.L04InterfacesAndAbstraction.P04SayHelloExtended;

public class Bulgarian extends BasePerson {
    private String name;

    public Bulgarian(String name) {
        super(name);
    }

    public String sayHello() {
        return "Здравей";
    }
}
