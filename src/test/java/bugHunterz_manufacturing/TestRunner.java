package bugHunterz_manufacturing;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.LoginPage;
import locators.MainPage;
import locators.ManufacturingHomePage;
import locators.ManufacturingReportingPage;
import locators.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.Config;
import utilities.Driver;

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
    @AfterMethod
    public void close()
    {
//        driver.close();
//        driver = null;
        Driver.quitDriver();
    }




}
