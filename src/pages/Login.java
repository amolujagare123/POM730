package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    //WebDriver driver = new ChromeDriver();;

  //  WebElement txtUser1 = driver.findElement(By.xpath("//input[@id='email']"));

    @FindBy (xpath="//h1[normalize-space()='Login']")
    public WebElement lblLogin;

    @FindBy (xpath="//label[normalize-space()='Email']")
    public WebElement lblEmail;

    @FindBy (xpath="//label[normalize-space()='Password']")
    public WebElement lblPassword;


    @FindBy (xpath="//input[@id='email']")
    public WebElement txtUser;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy (xpath="//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy (xpath = "//a[@class='btn btn-default']")
    public WebElement btnForgotPass;

    public  Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickBtnForgotPass()
    {
        btnForgotPass.click();
    }

    public void clickBtnLogin()
    {
        btnLogin.click();
    }

    public void setTxtUser(String username)
    {
        txtUser.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }
}
