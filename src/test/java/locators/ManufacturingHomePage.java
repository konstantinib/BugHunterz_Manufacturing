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

    @FindBy(xpath = "//div[@class = 'o_sub_menu_content']/div[6]/ul[3]/li/a")
    public WebElement getReportingManufacturingLink;


}
