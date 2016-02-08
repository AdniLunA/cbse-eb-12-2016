import com.google.common.eventbus.EventBus;

public class Mediator {
    private int id;
    private EventBus eventBus;

    public Mediator(int id){
        this.id = id;
        eventBus = new EventBus("Med-" + id);
    }

    public void addSubscriber(Subscriber subscriber)  {
        eventBus.register(subscriber);
    }

    public void transaction(int payCardType, double costs){

        if (payCardType == 1) {
            eventBus.post(new OrderCompleteEvent(1, 1, costs)); //todo warum immer id 1??? vlt besser id
        }
        else if (payCardType == 2) {
            eventBus.post(new OrderCompleteEvent(1, 2, costs));
        }
    }



    /*
    public void payWithComponent1() {

    }


    public void payWithComponent2() {

    }*/
}
