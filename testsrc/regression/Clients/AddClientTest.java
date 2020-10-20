package regression.Clients;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClients;
import util.DoLogin;
import util.OpenUrl;

import java.io.IOException;
import java.text.ParseException;

import static utility.ConfigReader.getPassword;
import static utility.ConfigReader.getUsername;

public class AddClientTest extends DoLogin {

    @Test
    public void addclientTest() throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClients addClients = new AddClients(driver);

       /* addClients.setClientName("amol");
        addClients.setSurname("Ujagare");
        addClients.setAddress1("katraj");
        addClients.setAddress2("Pune");
        addClients.setCity("Pune");
        addClients.setState("maharashtra");
        addClients.setZip("7889899");
        addClients.setPhone("99999");
         addClients.setFax("sdsdsd");
         addClients.setMobile("89898");
         addClients.setEmail("amol@gmail.com");
         addClients.setWeb("www.fb.com");
         addClients.setTax("8989");
         addClients.setVat("676767");

         addClients.setlanguage("English");

         addClients.setCountry("Indonesia");

         addClients.setGender("Other");

        addClients.clickSave();*/

        addClients.setBirthDate("01/05/2020"); // MM/dd/yyyy

        // dd/MM/yyyy



    }


}
