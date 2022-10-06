package regression;

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

import static util.ConfigReader.*;
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
                              String vat, String tax ,String expected,String xpathActual)
    {
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

        String actual = "";
        try {
             actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return getMyData("Data/InvoicePlaneData.xlsx","Sheet1");
    }
}
