import com.google.common.eventbus.EventBus;

import java.lang.reflect.Method;

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

    public void transaction(double price, Object port, String version){

            eventBus.post(new OrderCompleteEvent(1, price, version));
            Class[] parameterTypes = {double.class};
            Method method2 = null;
            try {
                method2 = port.getClass().getMethod("payment",parameterTypes);

                Object[] parameterValues = {price};
                String result = (String)method2.invoke(port,parameterValues);
            //    System.out.println("result : " + result);

                eventBus.post(new PaymentCompleteEvent(1, result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
