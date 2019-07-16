package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturingReportingPage {

    public WebDriver driver;

    public ManufacturingReportingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By advancedSeachButton = By.cssSelector("o_searchview_more.fa.fa-search-plus");

    public WebElement getAdvancedSearchButton()
    {
        return driver.findElement(advancedSeachButton);
    }
}
