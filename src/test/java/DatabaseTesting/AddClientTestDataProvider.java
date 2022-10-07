package DatabaseTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.ConfigReader.*;
import static utility.Conversion.*;
import static utility.ForDataProvider.getMyData;
import static utility.ForExcel.convertToNumberString;

public class AddClientTestDataProvider {
    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickBtnLogin();
    }

    @Test (dataProvider = "getData")
    public void addClientTest(String name, String surname,
                              String language, String address1,
                              String address2, String city, String state,
                              String zip, String country, String gender,
                              String birthdate, String phone, String fax,
                              String mobile, String email, String web,
                              String vat, String tax) throws ClassNotFoundException, SQLException, ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);
        
        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAddress1(address1);
        addClient.setClientAddress2(address2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(convertToNumberString(zip));
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthdate);
        addClient.setClientPhone(convertToNumberString(phone));
        addClient.setClientFax(convertToNumberString(fax));
        addClient.setClientMobile(convertToNumberString(mobile));
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(convertToNumberString(vat));
        addClient.setClientTax(convertToNumberString(tax));
        addClient.clickSave();

        ArrayList<String> expected = new ArrayList<String>();

        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(convertToNumberString(zip));
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(convertToNumberString(phone));
        expected.add(convertToNumberString(fax));
        expected.add(convertToNumberString(mobile));
        expected.add(email);
        expected.add(web);
        expected.add(convertToNumberString(vat));
        expected.add(convertToNumberString(tax));


        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con  = DriverManager.getConnection(url,username,password);

        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<String>();

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

            String fullFormCountry =  convertCountry(shortCountry);

            actual.add(fullFormCountry);



            actual.add(getGender(rs.getString("client_gender")));



            actual.add(convertDate(rs.getString("client_birthdate")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected);

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return getMyData("Data/InvoicePlaneData.xlsx","Sheet2");
    }
}
