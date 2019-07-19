package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductsPage {

    public WebDriver driver;

    public ProductsPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(css = ".o_searchview_more.fa.fa-search-plus")
    public WebElement advancedSearchButton;

    @FindBy(xpath = "//div[@class='btn-group o_dropdown']/button")
    public WebElement filtersLink;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_filters_menu']")
    public WebElement filtersDropDownMenu;

    @FindBy(xpath = "//a[@href='/web#menu_id=437&action=603']")
    public WebElement productButton;

    @FindBy(className = "o_searchview_input")
    public WebElement searchButton;

    @FindBy(linkText = "Products")
    public WebElement productsButton;

    @FindBy(xpath = "//div[@class='oe_kanban_global_click o_kanban_record'][1]")
    public WebElement firstProduct;

    @FindBy(xpath ="//button[@accesskey='a']")
    public WebElement edit;

    @FindBy(css = "[class*='o_field_number o_input'] .o_input")
    public WebElement sales;

    @FindBy(css = ".btn.btn-primary.btn-sm.o_form_button_save")
    public WebElement saveButton;

    @FindBy(css = ".o_notification_manager")
    public WebElement alertMessageList;
}
