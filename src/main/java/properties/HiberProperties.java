package properties;

import java.io.FileInputStream;
import java.util.Properties;

public class HiberProperties {
    private static final Properties properties = new Properties();

    public static Properties getProperties() {
        FileInputStream fis;

        if(properties.isEmpty()) {
            try {
                fis = new FileInputStream("C:\\Users\\user\\Maxim\\IT\\Max\\new_enter_project\\src\\main\\resources\\hibernate.cfg.xml");
                properties.load(fis);

            } catch (Exception e) {
                System.out.println("Cant init application properties " + e.getMessage());
            }
        }
        return properties;

    }
}