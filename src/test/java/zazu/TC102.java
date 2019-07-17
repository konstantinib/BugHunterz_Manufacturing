package zazu;

import locators.LoginPage;
import locators.MainPage;
import locators.ManufacturingHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Config;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC102 {
    static WebDriver driver = Driver.getDriver();
    static LoginPage loginPage;
    static MainPage mainPage;
    static ManufacturingHomePage manufacturingHome;

    @BeforeMethod
    public void loginAndGoToManufacturingLink()  throws InterruptedException{
        //1st Initialize the loginPage & mainPage constructor
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        //2nd Navigating to Log-In Page
        driver.get(Config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //3rd Entering username
        loginPage.getUsernameTextField().sendKeys(Config.getProperty("username"));

        //4th Entering password
        loginPage.getPasswordTextField().sendKeys(Config.getProperty("password"));

        //5th Clicking the "Login" button
        loginPage.getLoginButton().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //6th Click the "Manufacturing" link on the top navigation bar
        mainPage.getManufactoringLink().click();
        Thread.sleep(3000);


    }


    @Test
    public void aizada_FilterButton() throws InterruptedException
    {
       Thread.sleep(3000);
       // 1- Click on second ManufacturingOrders link in Manufacturing home page
       WebElement manufacturingOrderLink = driver.findElement(By.xpath("(//span[@class='oe_menu_text'])[19]"));
       manufacturingOrderLink.click();

       String actualMOLDisplayed = driver.findElement(By.xpath("(//span[@class='oe_menu_text'])[19]")).getText();
       String expectedResult = "Manufacturing Orders";

       // 2- Creating an object of SoftAssert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualMOLDisplayed.equals(expectedResult));
        Thread.sleep(3000);

        // 3- Click on plus button, to see the filter button
       WebElement plusButton = driver.findElement(By.xpath("//span[@title='Advanced Search...']"));
       plusButton.click();

       // 4- Checking the plus button is changed to minus
       WebElement advanceSearch = driver.findElement(By.xpath("//span[@title='Advanced Search...']"));
        softAssert.assertTrue(advanceSearch.getAttribute("class").contains("minus"));
        Thread.sleep(3000);

       // 5- Click on filters button
       WebElement filtersButton = driver.findElement(By.xpath("(//button[@aria-expanded='false'])[2]"));
       filtersButton.click();
        WebElement filters = driver.findElement(By.xpath("(//button[@aria-expanded='false'])[2]"));
       softAssert.assertTrue(filters.getAttribute("class").contains("toggle"));



            }

        }
