package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static utility.ConfigReader.getUrl;
import static utility.Driver.getDriver;

public class Calendarpractice {

     // refer video https://www.youtube.com/watch?v=yW1-IbI_soc

    public WebDriver driver;

    @BeforeClass
    public void openUrl() throws IOException {

        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/

        driver =getDriver(Driver.DriverTypes.CHROME);

        driver.get("https://jqueryui.com/datepicker/");
    }


    @Test

    public void mytest()
    {
        // swicth to frame

        WebElement iframe = driver.findElement(By.className("demo-frame"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.id("datepicker")).click();

        String setDateStr = "23/03/2020";




    }


}
