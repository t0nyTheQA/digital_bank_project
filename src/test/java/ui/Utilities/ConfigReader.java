package ui.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    //static initializer run the block only once for the whole month
    //instance initializer run the block once for every object creation from the class
    static {

        String filePath = "src/test/resources/properties/digitalbank.properties";

        FileInputStream inputStream = null; //class that enables you to read files

        try {
            inputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
    }

    public static String getPropertiesValue(String key){
        return properties.getProperty(key);
    }

}
