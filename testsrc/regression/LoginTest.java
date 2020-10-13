package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static utility.ConfigReader.getUrl;
import static utility.ConfigReader.getUsername;

public class LoginTest extends OpenUrl {


    @Test
    public void logintest() throws IOException {

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword("admin123");
        login.clickBtnLogin();

    }

}
