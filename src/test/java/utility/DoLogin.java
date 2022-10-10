package utility;

import org.testng.annotations.BeforeClass;
import pages.Login;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class DoLogin extends OpenUrl{
    public Login login;

    @BeforeClass
    public void doLogin() throws IOException {
        login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickBtnLogin();
    }
}
