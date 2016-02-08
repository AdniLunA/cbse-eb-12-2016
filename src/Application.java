import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Application {
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String... args) {
        int componentType = 1;
        String componentSubPath = "";

        OrderSystem orderSystem = new OrderSystem(1);
        PaymentSystem paymentSystem = new PaymentSystem(1);

        Products order = new Products();
        double price = order.generateOrder();

        Mediator mediator = new Mediator(1);
        mediator.addSubscriber(orderSystem);
        mediator.addSubscriber(paymentSystem);


        if (componentType == 1)
            componentSubPath = "exchangeComponent01";
        else if (componentType == 2)
            componentSubPath = "exchangeComponent02";

        String userDirectory = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        String pathToJar = userDirectory + fileSeparator + componentSubPath + fileSeparator + "Component.jar";
        //System.out.println("pathToJar : " + pathToJar);

        try {       //load Component
            URL[] urls = {new File(componentSubPath + "/Component.jar").toURI().toURL()};
			URLClassLoader urlClassLoader = new URLClassLoader(urls,Application.class.getClassLoader());
			Class clazz = Class.forName("Component",true,urlClassLoader);
            //System.out.println("clazz : " + clazz.toString());

            Method method1 = clazz.getDeclaredMethod("getVersion");
            //System.out.println(method1);
			
			Object instance = clazz.getMethod("getInstance", new Class[0]).invoke(null,new Object[0]);
			String version = (String) method1.invoke(instance);
			//System.out.println("version : " + version);


            Object port = clazz.getDeclaredField("port").get(instance);
            mediator.transaction(price, port, version);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}