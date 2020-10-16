package pages.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClients {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement surname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement address1;

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement address2;



    @FindBy (xpath="//input[@id='client_city']") WebElement city;
    @FindBy (xpath="//input[@id='client_state']") WebElement state;
    @FindBy (xpath="//input[@id='client_zip']") WebElement zip;
    @FindBy (xpath="//input[@id='client_phone']") WebElement phone;
    @FindBy (xpath="//input[@id='client_fax']") WebElement fax;
    @FindBy (xpath="//input[@id='client_web']") WebElement web;
    @FindBy (xpath="//input[@id='client_vat_id']") WebElement vat;
    @FindBy (xpath="//input[@id='client_tax_code']") WebElement tax;
    @FindBy (xpath="//button[@id='btn-submit']") WebElement btnSave;

    public void setCity(String cityTxt)
    {
        city.sendKeys(cityTxt);
    }

    public void setState(String stateTxt)
    {
        state.sendKeys(stateTxt);
    }
    public void setZip(String zipTxt)
    {
        zip.sendKeys(zipTxt);
    }
    public void setPhone(String phoneTxt)
    {
        phone.sendKeys(phoneTxt);
    }
    public void setFax(String faxTxt)
    {
        fax.sendKeys(faxTxt);
    }
    public void setTax(String taxTxt)
    {
        tax.sendKeys(taxTxt);
    }
    public void setVat(String vatTxt)
    {
        vat.sendKeys(vatTxt);
    }

    public void clickSave()
    {
        btnSave.click();
    }



    public AddClients(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    public void setSurname(String surnametext)
    {
        surname.sendKeys(surnametext);
    }

    public void setAddress1(String add1)
    {
        address1.sendKeys(add1);
    }

    public void setAddress2(String add2)
    {
        address2.sendKeys(add2);
    }


}
