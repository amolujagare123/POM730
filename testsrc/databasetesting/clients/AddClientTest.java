package databasetesting.clients;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClients;
import util.DoLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utility.Conversion.convertcountry;

public class AddClientTest extends DoLogin {


    @Test(dataProvider = "getData")
    public void addclientTest(String name, String  surname, String 	language,
                              String add1,String 	add2,String city,String state,
                              String 	zip,String 	country,String 	gender,
                              String 	birthdate,String 	phone,String  	fax,
                              String 	mob,String 	email,String 	website,String 	vat,
                              String 	tax) throws ParseException, ClassNotFoundException, SQLException {

        ArrayList<String> expected = new ArrayList<>();

        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mob);
        expected.add(email);
        expected.add(website);
        expected.add(vat);
        expected.add(tax);

        System.out.println(expected);


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

        Class.forName("com.mysql.cj.jdbc.Driver");

        String user ="root";
        String pass ="root";
        String url = "jdbc:mysql://localhost:3306/ipevening";

        Connection con  = DriverManager.getConnection(url,user,pass);

        Statement st = con.createStatement();

        String sql ="select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullCountry = convertcountry(shortCountry);
            actual.add(fullCountry);


            actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println(actual);

        Assert.assertEquals(actual,expected,"records mismatch in table");




    }

    @DataProvider
    public Object[][] getData() throws IOException {


        FileInputStream fp = new FileInputStream("Data\\data.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet2");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][18];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<18;j++)
            {
                XSSFCell element = row.getCell(j);
                data[i][j] = element.toString().trim();
            }

        }

        return data;
    }

}
