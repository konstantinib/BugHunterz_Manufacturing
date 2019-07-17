package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturingHomePage {

    public WebDriver driver;

    public ManufacturingHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    By reportingManufacturingLink = By.linkText("Manufacturing");

    public WebElement getReportingManufactoringLink()
    {
        return driver.findElement(reportingManufacturingLink);
    }
}
