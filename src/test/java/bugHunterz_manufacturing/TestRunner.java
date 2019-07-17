package bugHunterz_manufacturing;

import locators.LoginPage;
import locators.MainPage;
import locators.ManufacturingHomePage;
import locators.ManufacturingReportingPage;
import locators.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Config;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRunner {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    ManufacturingHomePage manufacturingHome;
    ManufacturingReportingPage manufacturingReportPage;
    ProductsPage productPage;



    @BeforeMethod
    public void loginAndGoToManufacturingLink()
    {
        //driver = Driver.getDriver();
        //2nd Navigating to Log-In Page
        Driver.getDriver().get(Config.getProperty("url"));
        //driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);

        //1st Initialize the loginPage & mainPage constructor
        loginPage = new LoginPage();
        mainPage = new MainPage();


        //3rd Entering username
        loginPage.getUsernameTextField.sendKeys(Config.getProperty("username"));

        //4th Entering password
        loginPage.getPasswordTextField.sendKeys(Config.getProperty("password"));

        //5th Clicking the "Login" button
        loginPage.getLoginButton.click();
        //driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);

        //6th Click the "Manufacturing" link on the top navigation bar
        mainPage.getManufacturingLink.click();
        //driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);

    }

    @Test(priority = 1)

    public void Cesar_groupByRouting() throws InterruptedException
    {
        manufacturingHome = new ManufacturingHomePage();

        Actions actions = new Actions(Driver.getDriver());


        Thread.sleep(3000);
        //1st Click on the "Manufacturing Orders" link under "Reporting"
        actions.moveToElement(manufacturingHome.getReportingManufacturingLink).click().perform();
        //manufacturingHome.getReportingManufacturingLink.click();

        //2nd Click on the "Advanced Search" link on the search bar
        manufacturingReportPage = new ManufacturingReportingPage();
        Thread.sleep(3000);
        actions.moveToElement(manufacturingReportPage.getAdvancedSearchButton).click().perform();

        //3rd Click on the "Group By" button
        actions.moveToElement(manufacturingReportPage.getGroupByButton).click().perform();

        //4th Click on the "Routing" link in the drop down menu
        Thread.sleep(1000);
        actions.moveToElement(manufacturingReportPage.getRoutingLink).click().perform();
       // driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);


        //5th Once we click on the "Routing" link, we should assert that new graph is displayed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(manufacturingReportPage.getGraph.isDisplayed(), "Graph was not displayed!");
        System.out.println("Cesar's Method Finished With No Problems");
    }

    @Test(priority = 2)

    public void Konstantin_FiltersDropDownMenu() throws InterruptedException{
        manufacturingHome = new ManufacturingHomePage();
        Thread.sleep(2000);

//     Click on "Product" link under "Master Data"
        manufacturingHome.productsLink.click();

//     Verify that advanced search is on
        Thread.sleep(2000);
        productPage = new ProductsPage();
        productPage.advancedSearchButton.click();

//     Locate and click on "Filters" button
        Thread.sleep(2000);
        productPage.filtersLink.click();

//     Verifying that dropdown menu is displayed
        Thread.sleep(1000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productPage.filtersDropDownMenu.isDisplayed(), "Drop down menu is not displayed!");

    }

    @Test(priority = 3)
    public void EmreSearchFunctionalityInProductSection() throws InterruptedException {

        Thread.sleep(5000);

        Actions action = new Actions(Driver.getDriver());
        WebElement scrollingDown = Driver.getDriver().findElement(By.xpath("//td[@title='Total Qty']"));
        // to scroll down to the end of the page
        action.moveToElement(scrollingDown).perform();

        Thread.sleep(3000);
        ProductsPage product = new ProductsPage();
        action.moveToElement(product.searchButton);
        Thread.sleep(2000);
        // click the product button on the home page
        product.productButton.click();

        // storing all the lists into Webelement of List
        List<WebElement> allList = Driver.getDriver().findElements(By.xpath("//div[@class='o_kanban_view o_kanban_ungrouped']//strong"));
        // loop through all list
        for(WebElement w: allList){

            if(w.getText().equals("Book")){
                // choosing the product that we're looking for
                w.click();
                break;
            }
        }
        // going back to previous page
        Thread.sleep(4000);
        Driver.getDriver().navigate().back();

        Thread.sleep(2000);
        // putting input into searchButton
        product.searchButton.sendKeys("iphone 8");
        Thread.sleep(2000);
        // deleting input from searchButton
        product.searchButton.clear();
        Thread.sleep(2000);
        // putting input into searchButton and pressing enter
        product.searchButton.sendKeys("IPHONE 8" + Keys.ENTER);

        boolean check = false;
        Thread.sleep(3000);
        // storing all the results into List
        List<WebElement> listForInput = Driver.getDriver().findElements(By.xpath("//div[@class='o_kanban_view o_kanban_ungrouped']//strong"));

        for(WebElement w: listForInput){
            if(w.getText().equalsIgnoreCase("iphone 8")){
                check = true;
            }
        }
        Assert.assertTrue(check);



    }
    @AfterMethod
    public void close()
    {
//        driver.close();
//        driver = null;
        Driver.quitDriver();
    }




}
