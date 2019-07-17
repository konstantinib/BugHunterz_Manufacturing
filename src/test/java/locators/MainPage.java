package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {

    public WebDriver driver;

    public MainPage()
    {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(linkText = "Manufacturing")
    public WebElement getManufacturingLink;

}
