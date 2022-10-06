package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static util.ConfigReader.*;

public class AddClientTest {
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

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName("Modin");
        addClient.setClientSurname("Gadikar");
        addClient.setLanguage("French");
        addClient.setClientAddress1("xyz");
        addClient.setClientAddress2("abc");
        addClient.setClientCity("pune");
        addClient.setClientState("MH");
        addClient.setClientZip("414008");
        addClient.setCountry("Myanmar [Burma]");
        addClient.setGender("Other");
        addClient.setBirthDate("12/29/1985");
        addClient.setClientPhone("7787878");
        addClient.setClientFax("54545");
        addClient.setClientMobile("545454");
        addClient.setClientEmail("a@b.com");
        addClient.setClientWeb("www.google.com");
        addClient.setClientVat("434434");
        addClient.setClientTax("43434");
        addClient.clickSave();


    }
}
