import com.google.common.eventbus.Subscribe;

public class PaymentSystem extends Subscriber{
    private int id;

    public PaymentSystem(int id) {
        super(id);
    }

    @Subscribe
    public void receive(PaymentCompleteEvent paymentCompleteEvent){
        String result = paymentCompleteEvent.getResult();
        System.out.println(result);

    }

}
