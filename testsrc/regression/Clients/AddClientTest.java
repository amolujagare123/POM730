package regression.Clients;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClients;
import util.DoLogin;
import util.OpenUrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import static utility.ConfigReader.getPassword;
import static utility.ConfigReader.getUsername;

public class AddClientTest extends DoLogin {

    @Test(dataProvider = "getData")
    public void addclientTest(String name, String  surname, String 	language,
                              String add1,String 	add2,String city,String state,
                              String 	zip,String 	country,String 	gender,
                              String 	birthdate,String 	phone,String  	fax,
                              String 	mob,String 	email,String 	website,String 	vat,
                              String 	tax,String expected, String xpathActual) throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClients addClients = new AddClients(driver);

        addClients.setClientName(name);
        addClients.setSurname(surname);
        addClients.setAddress1(add1);
        addClients.setAddress2(add2);
        addClients.setCity(city);
        addClients.setState(state);
        addClients.setZip(zip);
        addClients.setPhone(phone);
        addClients.setFax(fax);
        addClients.setMobile(mob);
        addClients.setEmail(email);
        addClients.setWeb(website);
        addClients.setTax(tax);
        addClients.setVat(vat);
        addClients.setBirthDate(birthdate); // MM/dd/yyyy
        addClients.setlanguage(language);
        addClients.setCountry(country);
        addClients.setGender(gender);
        addClients.clickSave();

        String actual="";

        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"This is worng message");

    }

    @DataProvider
    public Object[][] getData() throws IOException {


        FileInputStream fp = new FileInputStream("Data\\data.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][20];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<20;j++)
            {
                XSSFCell element = row.getCell(j);
                data[i][j] = element.toString().trim();
            }

        }

            return data;
    }


}
