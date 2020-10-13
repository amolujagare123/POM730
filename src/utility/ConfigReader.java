package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getPropertiesObject() throws IOException {

        // this method returns the loaed properties object
        // with the file object that has the propeties file path

        FileInputStream fp = new FileInputStream("resources\\project.properties");
        Properties prop = new Properties();
        prop.load(fp);
        return prop;

    }

    public static  String getUrl() throws IOException {

       return getPropertiesObject().getProperty("url");
    }

    public static String getUsername() throws IOException {
        return getPropertiesObject().getProperty("username");
    }

}
