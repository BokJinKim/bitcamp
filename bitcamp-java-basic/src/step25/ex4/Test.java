package step25.ex4;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws Exception {
        
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("---------------------");
        
        Properties jvmProps = System.getProperties();
        Set<Object> keySet = jvmProps.keySet();
        for (Object key : keySet) {
            System.out.printf("%s=%s\n", key, jvmProps.get(key));
        }
        System.out.println("---------------------");
        
        Properties fileProps = new Properties();
        fileProps.load(new FileInputStream("jdbc.properties"));
        keySet = fileProps.keySet();
        for (Object key : keySet) {
            System.out.printf("%s=%s\n", key, fileProps.get(key));
        }
        System.out.println("---------------------");
    }
}
