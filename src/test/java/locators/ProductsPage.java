package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

}
