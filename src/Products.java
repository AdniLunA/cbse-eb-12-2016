import java.util.*;
import java.math.*;

public class Products {
    private double[] products = {12.34, 34.56, 1.23, 50.00, 1.00, 1.50, 2.99, 25.12, 6.50, 8.15, 10.20, 21.12};
    private double sum=0;

    public double generateOrder(){
        for (int i = 0; i <= 5; i++) {
            int randomNumber = (int)Math.round(Math.random()*11);
            sum += products[randomNumber];
        }
        return sum;
    }
}
