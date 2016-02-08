
public class PaymentCompleteEvent {
    private int id;
    private String result;

    PaymentCompleteEvent(int id, String result){
        this.id = id;
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}