package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy (xpath = "//a[normalize-space()='Dashboard']")
    WebElement dashboard;

    @FindBy (xpath = "//span[normalize-space()='Clients']")
    WebElement clients;

    @FindBy (xpath = "//a[contains(text(),'Add Client')]")
    WebElement addClient;

    @FindBy (xpath = "//a[normalize-space()='View Clients']")
    WebElement viewClients;

    @FindBy (xpath = "//span[normalize-space()='Quotes']")
    WebElement quote;

    @FindBy (xpath = "//a[@class='create-quote']")
    WebElement createQuote;

    @FindBy (xpath = "//a[normalize-space()='View Quotes']")
    WebElement viewQuote;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickDashboard()
    {
        dashboard.click();
    }

    public void clickAddClient()
    {
        clients.click();
        addClient.click();
    }

    public void clickViewClient()
    {
        clients.click();
        viewClients.click();
    }

    public void clickCreateQuote()
    {
        quote.click();
        createQuote.click();
    }

    public void clickViewQuotes()
    {
        quote.click();
        viewQuote.click();
    }


}
