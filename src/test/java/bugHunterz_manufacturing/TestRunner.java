package bugHunterz_manufacturing;

import locators.LoginPage;
import locators.MainPage;
import locators.ManufacturingHomePage;
import locators.ManufacturingReportingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    static WebDriver driver = Driver.getDriver();
    static LoginPage loginPage;
    static MainPage mainPage;
    static ManufacturingHomePage manufacturingHome;
    static ManufacturingReportingPage manufacturingReportPage;


    @BeforeMethod
    public void loginAndGoToManufacturingLink()
    {
        //1st Initialize the loginPage & mainPage constructor
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        //2nd Navigating to Log-In Page
        driver.get(Config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);

        //3rd Entering username
        loginPage.getUsernameTextField.sendKeys(Config.getProperty("username"));

        //4th Entering password
        loginPage.getPasswordTextField.sendKeys(Config.getProperty("password"));

        //5th Clicking the "Login" button
        loginPage.getLoginButton.click();
        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);

        //6th Click the "Manufacturing" link on the top navigation bar
        mainPage.getManufacturingLink.click();
        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);

    }

    @Test
    public void Cesar_groupByRouting() throws InterruptedException
    {
        manufacturingHome = new ManufacturingHomePage(driver);


        Thread.sleep(4000);
        //1st Click on the "Manufacturing Orders" link under "Reporting"
        manufacturingHome.getReportingManufacturingLink.click();

        //2nd Click on the "Advanced Search" link on the search bar
        manufacturingReportPage = new ManufacturingReportingPage(driver);
        Thread.sleep(3000);
        manufacturingReportPage.getAdvancedSearchButton.click();

        //3rd Click on the "Group By" button
        manufacturingReportPage.getGroupByButton.click();

        //4th Click on the "Routing" link in the drop down menu
        Thread.sleep(1000);
        manufacturingReportPage.getRoutingLink.click();

    }






}
