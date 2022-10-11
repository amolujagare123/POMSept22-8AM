package UITesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenUrl;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends OpenUrl {
    Login login;

    @BeforeClass
    public void init() {
        login = new Login(driver);
    }

    @Test
    public void txtUsernamevisibility() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtUsername.isDisplayed();
        } catch (Exception e) {

        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "element is not there");

    }

    @Test
    public void txtPasswordEnability() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtPassword.isEnabled();
        } catch (Exception e) {

        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "element is not enabled/not present");

    }

    @Test
    public void lblEmailSpellCheck() {
        String expected = "Email";
        String actual = "";
        try {
            actual = login.lblEmail.getText();
        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "incorrect spelling /element not present");

    }

    @Test
    public void txtPasswordWatermarkCheck() {
        String expected = "Password";
        String actual = "";

        try {
            actual = login.txtPassword.getAttribute("placeholder");
        } catch (Exception e) {
            //  e.printStackTrace();
        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "incorrect watermark /element not present");

    }

    @Test
    public void lblPasswordFontSizeCheck() {
        String expected = "14px";
        String actual = "";

        try {
            actual = login.lblPassword.getCssValue("font-size");
        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "incorrect font size /element not present");


    }


    @Test
    public void lblPasswordFontFamilyCheck() {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = "";

        try {
            actual = login.lblPassword.getCssValue("font-family");
        } catch (Exception e) {

        }

        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "incorrect font family /element not present");

    }

    @Test
    public void lblPasswordFontCheck() {
        // check whether the font 'sans-serif' is present in the font family of the label or not
        String expected = "Times New Roman";

        String actual = "";

        try {
            actual = login.lblPassword.getCssValue("font-family");
        } catch (Exception e) {

        }

        boolean result = actual.contains(expected); // true / false

        Assert.assertTrue(result, expected + ":font is not there in the font family");

    }

    @Test
    public void btnLoginColorCheck() {
        String expected = "#2C8EDD";

        String actual = "";

        try {
            String colorRgb = login.btnLogin.getCssValue("background-color");

            actual = Color.fromString(colorRgb).asHex().toUpperCase();
        } catch (Exception e) {

        }
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected, "incorrect color /element not present");

    }

    // check email and password are sequentially placed

    @Test
    public void checkTextBoxSequence() {

        ArrayList<String> expected = new ArrayList<String>() {{
            add("email");
            add("password");
        }};

         List<WebElement> inputList = driver.findElements(By.tagName("input"));

        ArrayList<String> actual = new ArrayList<String>() ;
        actual.add(inputList.get(1).getAttribute("id"));
        actual.add(inputList.get(2).getAttribute("id"));


        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        Assert.assertEquals(actual, expected);

    }

}
