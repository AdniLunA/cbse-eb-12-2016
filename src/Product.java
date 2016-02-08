import java.util.Random;


public class Product {
    private String name;
    private double price;

    public Product (String name){
        this.name = name;
        this.price = (double) (Math.random()*100);
    }

    public Product (String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
