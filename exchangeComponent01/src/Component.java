import java.lang.reflect.Method;

public class Component{
    private static Component instance = new Component();
    public Port port;

    private Component() {
        port = new Port();
    }

    public static Component getInstance() {
        return instance;
    }

    public String getVersion() {
        return "Component: Payment with DebitCard";
    }

    public class Port implements IComponent {
        private Method[] methods = getClass().getMethods();

        public void printComponentVersion() {
            System.out.println(getVersion() + "\n");
        }

        public String payment(int sum) {
            return innerMethod(sum);
        }


        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    private String innerMethod(int sum) { //payment
        return "Payment complete: "+ sum+"€ have been payed./nThe customer is happy.";
    }
}