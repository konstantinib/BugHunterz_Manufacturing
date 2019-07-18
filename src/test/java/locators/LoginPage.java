package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class LoginPage {

    public WebDriver driver;


    public LoginPage()
    {
        driver = Driver.getDriver();
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(css= "#login")
    public WebElement getUsernameTextField;

    @FindBy(css = "#password")
    public WebElement getPasswordTextField;

    @FindBy(css = ".btn.btn-primary")
    public WebElement getLoginButton;


/*  By usernameTextField = By.cssSelector("#login");
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
    }*/






}
