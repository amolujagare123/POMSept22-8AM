package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesDemo {

    public static void main(String[] args) throws IOException {

        // 1. read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        // 2. create the object of Properties class
        Properties prop = new Properties();

        // 3. load this object with the file object
        prop.load(fis);

        // 4. read the value of the key
        System.out.println(prop.getProperty("url"));

    }
}
