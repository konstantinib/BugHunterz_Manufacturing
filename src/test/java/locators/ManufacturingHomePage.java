package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManufacturingHomePage {

    public WebDriver driver;

    public ManufacturingHomePage()
    {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(xpath = "//div[@class = 'o_sub_menu_content']/div[6]/ul[3]/li/a")
    public WebElement getReportingManufacturingLink;

    @FindBy(xpath = "//a[@data-menu='437']/span")
    public WebElement productsLink;


}
