package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManufacturingReportingPage {

    public WebDriver driver;

    public ManufacturingReportingPage()
    {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver , this);
    }

    @FindBy(css = ".o_searchview_more.fa.fa-search-plus")
    public WebElement getAdvancedSearchButton;

    @FindBy(xpath = "//div[@class = 'btn-group o_search_options']/div[2]/button")
    public WebElement getGroupByButton;

    @FindBy(linkText = "Routing")
    public WebElement getRoutingLink;

    @FindBy(xpath = "//div[@class='o_graph']")
    public WebElement getGraph;


 /* By advancedSeachButton = By.cssSelector(".o_searchview_more.fa.fa-search-plus");
    By groupByButton = By.xpath();
    By routingLink = By.linkText("Routing");
    public WebElement getAdvancedSearchButton()
    {
        return driver.findElement(advancedSeachButton);
    }
    public WebElement getGroupByButton()
    {
        return driver.findElement(groupByButton);
    }
    public WebElement getRoutingLink(){ return  driver.findElement(routingLink); }*/
}