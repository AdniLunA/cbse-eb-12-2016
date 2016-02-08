import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Application {
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String... args) {
        int componentType = 1;
        String componentSubPath = "";

        if (componentType == 1)
            componentSubPath = "exchangeComponent01";
        else if (componentType == 2)
            componentSubPath = "exchangeComponent02";

        String userDirectory = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        String pathToJar = userDirectory + fileSeparator + componentSubPath + fileSeparator + "Component.jar";
        System.out.println("pathToJar : " + pathToJar);

        try {
            URL[] urls = {new File(componentSubPath + "/Component.jar").toURI().toURL()};
			URLClassLoader urlClassLoader = new URLClassLoader(urls,Application.class.getClassLoader());
			Class clazz = Class.forName("Component",true,urlClassLoader);
            System.out.println("clazz : " + clazz.toString());

            Method method1 = clazz.getDeclaredMethod("getVersion");
            System.out.println(method1);
			
			Object instance = clazz.getMethod("getInstance", new Class[0]).invoke(null,new Object[0]);
			String version = (String)method1.invoke(instance);
			System.out.println("version : " + version);
			
			Class[] parameterTypes = {String.class};
            Object port = clazz.getDeclaredField("port").get(instance);
            Method method2 = port.getClass().getMethod("method",parameterTypes);
            Object[] parameterValues = {"dhbw"};
            String result = (String)method2.invoke(port,parameterValues);
            System.out.println("result : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}