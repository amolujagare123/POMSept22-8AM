package UITesting;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenUrl;

public class LoginTest extends OpenUrl {
    Login login;

    @BeforeClass
    public void init()
    {
         login = new Login(driver);
    }

    @Test
    public void txtUsernamevisibility()
    {
        boolean expected = true;
        boolean actual= false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"element is not there");

    }

    @Test
    public void txtPasswordEnability()
    {
        boolean expected = true;
        boolean actual= false;
        try {
            actual = login.txtPassword.isEnabled();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"element is not enabled/not present");

    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = "";
        try {
             actual = login.lblEmail.getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect spelling /element not present");

    }

    @Test
    public void txtPasswordWatermarkCheck()
    {
        String expected = "Password";
        String actual = "";

        try
        {
            actual = login.txtPassword.getAttribute("placeholder");
        }
        catch (Exception e)
        {
         //  e.printStackTrace();
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect watermark /element not present");

    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected =  "14px";
        String actual = "";

        try
        {
            actual = login.lblPassword.getCssValue("font-size");
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect font size /element not present");


    }
}
