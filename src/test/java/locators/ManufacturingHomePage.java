package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ManufacturingHomePage {

    public WebDriver driver;

    public ManufacturingHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    By reportingManufacturingLink = By.xpath("//div[@class = 'o_sub_menu_content']/div[6]/ul[3]/li/a");

    public WebElement getReportingManufactoringLink() {return driver.findElement(reportingManufacturingLink);}


    @FindBy(xpath = "//a[@data-menu='437']/span")
    public WebElement productsLink;
}
