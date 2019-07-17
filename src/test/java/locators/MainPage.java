package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By manufactoringLink = By.linkText("Manufacturing");

    public WebElement getManufactoringLink()
    {

        return driver.findElement(manufactoringLink);
    }
}
