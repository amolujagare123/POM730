package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

public class LoginTest extends OpenUrl {

    Login login;


    @BeforeClass
    public void initObject()
    {
        login = new Login(driver);
    }


    @Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected = true;
        boolean actual = false;

        try {
           actual = login.txtUser.isDisplayed(); // true if present
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(actual,expected, "the element is not prseent on the page");
    }


    @Test
    public void txtUsernameEnabilityCheck()
    {
        boolean expected = true;
        boolean actual = false;

        try {
            actual = login.txtUser.isEnabled(); // true if present
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(actual,expected,
                "the element is not enabled");

    }

    @Test
    public void txtUsernameWatermarkCheck()
    {
        String expected = "Email";
        String actual ="";

        try
        {
            actual = login.txtUser.getAttribute("placeholder");
            System.out.println("actual:"+actual);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(actual,expected,"wrong watermark");
    }


    @Test
    public void lblPasswordSpellingCheck()
    {
        String expected = "Password";
        String actual = "";

         try{
             actual = login.lblPassword.getText();
             System.out.println("actual:"+actual);
         }
         catch (Exception e)
         {
             System.out.println(e.getMessage());
         }

        Assert.assertEquals(actual,expected,"wrong spelling");

    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected ="14px";
        String actual ="";
        try
        {
            actual = login.lblPassword.getCssValue("font-size");
            System.out.println("actual:"+actual);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(actual,expected,"wrong font");
    }


    @Test
    public void lblPasswordFontFamilyCheck()
    {
        String expected ="-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual ="";
        try
        {
            actual = login.lblPassword.getCssValue("font-family");
            System.out.println("actual:"+actual);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(actual,expected,"wrong font");
    }


    @Test
    public void lblPasswordFontCheck()
    {
        String expected ="sans-serif";
        String actual ="";
        try
        {
            actual = login.lblPassword.getCssValue("font-family");
            System.out.println("actual:"+actual);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

     boolean result =   actual.contains(expected);

        Assert.assertTrue(result,"the font family is absent");

    }


    @Test
    public void  btnLoginColorCheck()
    {
        String expected = "#2C8EDD";

        String actual ="";
        try
        {
            String objectColor = login.btnLogin.getCssValue("background-color");

            actual =  Color.fromString(objectColor).asHex().toUpperCase();

            System.out.println("actual:"+actual);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(actual,expected,"wrong color");
    }
}
