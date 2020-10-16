package regression.Clients;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClients;
import util.DoLogin;
import util.OpenUrl;

import java.io.IOException;

import static utility.ConfigReader.getPassword;
import static utility.ConfigReader.getUsername;

public class AddClientTest extends DoLogin {

    @Test
    public void addclientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClients addClients = new AddClients(driver);

        addClients.setClientName("amol");
        addClients.setSurname("Ujagare");
        addClients.setAddress1("katraj");
        addClients.setAddress2("Pune");
        addClients.setCity("Pune");
        addClients.setPhone("99999");

        addClients.clickSave();
    }


}
