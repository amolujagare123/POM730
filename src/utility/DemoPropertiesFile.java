package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;

public class DemoPropertiesFile {

    public static void main(String[] args) throws IOException {

        FileInputStream fp = new FileInputStream("resources\\project.properties");

        Properties prop = new Properties();

        prop.load(fp);

        System.out.println(prop.getProperty("url"));

        System.out.println(prop.getProperty("username"));
    }
}
