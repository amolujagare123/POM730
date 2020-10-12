package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest {

    WebDriver driver;

    @Test
    public void logintest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:82/ip-evening/index.php/sessions/login");

        Login login = new Login(driver);

        login.setTxtUser("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickBtnLogin();

    }

}
