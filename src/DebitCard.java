import com.google.common.eventbus.Subscribe;

public class DebitCard extends Subscriber{
    private int id;

    public DebitCard(int id) {
        super(id);
    }

    @Subscribe
    public void receive(OrderCompleteEvent orderCompleteEvent){
        System.out.println("Order complete. Initiating payment with DebitCard.");

    }


}
