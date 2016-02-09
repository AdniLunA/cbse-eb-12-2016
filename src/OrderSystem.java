import com.google.common.eventbus.Subscribe;

public class OrderSystem extends Subscriber{
    private int id;


    public OrderSystem(int id) {
        super(id);
    }

    @Subscribe
    public void receive(OrderCompleteEvent orderCompleteEvent){
        double price = orderCompleteEvent.getPrice();
        String version = orderCompleteEvent.getVersion();
        System.out.println("Order with value of "+price+" EUR complete. Initiating payment with "+version+".");

    }

    @Subscribe
    public void receive(PaymentCompleteEvent paymentCompleteEvent){
        System.out.println("Congratulations! The order has been sent.");
    }

}
