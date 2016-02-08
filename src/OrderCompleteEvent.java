
public class OrderCompleteEvent {
    private int id;
    private double price;
    private String version;

    OrderCompleteEvent(int id, double price, String version){
        this.id = id;
        this.price = price;
        this.version = version;
    }

    public double getPrice() {
        return price;
    }

    public String getVersion() {
        return version;
    }
}
