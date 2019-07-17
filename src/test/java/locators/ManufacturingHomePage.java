package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingHomePage {

    public WebDriver driver;

    public ManufacturingHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }


    By reportingManufacturingLink = By.linkText("Manufacturing");
    @FindBy(xpath = "//div[@class = 'o_sub_menu_content']/div[6]/ul[3]/li/a")
    public WebElement getReportingManufacturingLink;

    @FindBy(xpath = "//a[@data-menu='437']/span")
    public WebElement productsLink;


}
