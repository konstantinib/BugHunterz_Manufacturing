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

    @FindBy(linkText = "Manufacturing")
    public WebElement ManufactoringButton;

    @FindBy(linkText = "Bills of Materials")
    public WebElement BillOfMaterials;

    @FindBy(css = ".btn.btn-primary.btn-sm.o_list_button_add")
    public WebElement CreateButton;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement SaveButton;


    @FindBy(xpath = "//ol[@class='breadcrumb']//li")
    public WebElement ManufOrderDispayed;

    @FindBy(css = ".o_form_sheet")
    public WebElement WindowDisplay;

}
