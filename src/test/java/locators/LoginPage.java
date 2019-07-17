package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By usernameTextField = By.cssSelector("#login");
    By passwordTextField = By.cssSelector("#password");
    By loginButton       = By.cssSelector(".btn.btn-primary");

    public WebElement getUsernameTextField()
    {
        return driver.findElement(usernameTextField);
    }
    public WebElement getPasswordTextField()
    {
        return driver.findElement(passwordTextField);
    }
    public WebElement getLoginButton()
    {
        return driver.findElement(loginButton);
    }
}
