package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(linkText="Dashboard")
    WebElement dashbord;

    @FindBy (xpath="//span[contains(text(),'Clients')]")
    WebElement clients;

    @FindBy (xpath="//a[contains(text(),'Add Client')]")
    WebElement addClients;

    @FindBy (xpath="//a[contains(text(),'View Clients')]")
    WebElement viewClients;

    @FindBy (xpath="//span[contains(text(),'Quotes')]")
    WebElement quotes;

    @FindBy (xpath="//a[contains(text(),'Create Quote')]")
    WebElement createQuote;

    @FindBy (xpath="//a[contains(text(),'View Quotes')]")
    WebElement viewQuote;


    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickDashboard()
    {
     dashbord.click();
    }

    public void clickAddClient()
    {
        clients.click();
        addClients.click();
    }

    public void viewClients()
    {
        clients.click();
        viewClients.click();
    }

    public void  clickCreateQuote()
    {
        quotes.click();
        createQuote.click();
    }

    void clickViewQuotes()
    {
        quotes.click();
        viewQuote.click();
    }
}
