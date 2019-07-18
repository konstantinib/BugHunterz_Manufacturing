package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BillOfMaterialPage {
    public WebDriver driver;

    public BillOfMaterialPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(linkText = "Bills of Materials")
    public WebElement billOfMaretialsButton;

    @FindBy(xpath = "//label[@class='btn btn-primary']")
    public WebElement loadFile;

    @FindBy(xpath = "//a[.='Bills of Materials']")
    public WebElement billsOfMaterials;

    @FindBy(xpath = "//label[@class='btn btn-primary']")
    public WebElement loadFileButton;

}
