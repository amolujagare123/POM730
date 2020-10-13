package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import utility.Driver;

import java.io.IOException;

import static utility.ConfigReader.getUrl;
import static utility.Driver.getDriver;

public class OpenUrl {

   public  WebDriver driver;

    @BeforeClass
    public void openUrl() throws IOException {

        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/

        driver =getDriver(Driver.DriverTypes.FIREFOX);

        driver.get(getUrl());
    }
}
