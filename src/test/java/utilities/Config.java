package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties p = new Properties();

    static {
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            p.load(file);
            file.close();
        }
        catch (IOException e){
            System.out.println("Properties file is not found");
        }
    }

    public static String getProperty(String keyword){
        return p.getProperty(keyword);
        // Config.getProperty("url") can be called from everywhere inside the project
    }
}
