import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static util.ConfigReader.getUrl;

public class ForgotPasswordTest {

    @Test
    public void forgotPasswordTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);
        login.clickFogotPass();

        ForgotPassword forgotPassword = new ForgotPassword(driver);

        forgotPassword.setTxtEmail("abc@gmail.com");
        forgotPassword.clickResetBtn();


    }
}
