package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {

    static public WebDriver driver;

    public MainPage()
    {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(linkText = "Manufacturing")
    public WebElement getManufacturingLink;

    @FindBy(css = ".btn.btn-sm.btn-default.o_import_cancel")
    public WebElement cancelButton;

    @FindBy(css = ".breadcrumb .active")
    public WebElement title;

    @FindBy(css = ".btn.btn-sm.btn-default.o_button_import")
    public WebElement importButton;

}
