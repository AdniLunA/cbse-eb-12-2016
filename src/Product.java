import java.util.Random;


public class Product {
    private String name;
    private double price;

    public Product (String name){
        this.name = name;
        this.price = (double) (Math.random()*100);
    }



}
