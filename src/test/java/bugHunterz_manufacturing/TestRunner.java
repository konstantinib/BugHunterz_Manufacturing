package bugHunterz_manufacturing;
import locators.BillOfMaterialPage;
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

    SoftAssert soft;
    BillOfMaterialPage billOfMaterialsPage;


    @BeforeMethod
    public void loginAndGoToManufacturingLink()
    {
        //driver = Driver.getDriver();
        //1st Initialize the loginPage & mainPage constructor
        loginPage = new LoginPage();
        mainPage = new MainPage();

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

    @Test(priority = 4)
    public void aizada_FilterButton() throws InterruptedException
    {
        Thread.sleep(3000);
        // 1- Click on second ManufacturingOrders link in Manufacturing home page
        WebElement manufacturingOrderLink = Driver.getDriver().findElement(By.xpath("(//span[@class='oe_menu_text'])[19]"));
        manufacturingOrderLink.click();

        String actualMOLDisplayed = Driver.getDriver().findElement(By.xpath("(//span[@class='oe_menu_text'])[19]")).getText();
        String expectedResult = "Manufacturing Orders";

        // 2- Creating an object of SoftAssert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualMOLDisplayed.equals(expectedResult));
        Thread.sleep(3000);

        // 3- Click on plus button, to see the filter button
        WebElement plusButton = Driver.getDriver().findElement(By.xpath("//span[@title='Advanced Search...']"));
        plusButton.click();

        // 4- Checking the plus button is changed to minus
        WebElement advanceSearch = Driver.getDriver().findElement(By.xpath("//span[@title='Advanced Search...']"));
        softAssert.assertTrue(advanceSearch.getAttribute("class").contains("minus"));
        Thread.sleep(3000);

        // 5- Click on filters button
        WebElement filtersButton = Driver.getDriver().findElement(By.xpath("(//button[@aria-expanded='false'])[2]"));
        filtersButton.click();
        WebElement filters = Driver.getDriver().findElement(By.xpath("(//button[@aria-expanded='false'])[2]"));
        softAssert.assertTrue(filters.getAttribute("class").contains("toggle"));

    }
    @Test(priority = 7)
    public void NadejdaSaveButton() throws InterruptedException{
        SoftAssert soft;

        manufacturingHome = new ManufacturingHomePage();
        manufacturingReportPage =  new ManufacturingReportingPage();
        billOfMaterialsPage = new BillOfMaterialPage();

        soft = new SoftAssert();
        soft.assertTrue(manufacturingHome.UserText.getText().equals("ManufacturingManager"), "Login Verification Failed");
        mainPage = new MainPage();
        mainPage.getManufacturingLink.click();
        Thread.sleep(4000);
        soft.assertTrue(billOfMaterialsPage.ManufOrderDispayed.getText().contains("Manufacturing Orders"), "Manufacturing Button Verification Failed");
        billOfMaterialsPage.BillOfMaterials.click();
        Thread.sleep(2000);
        soft.assertTrue(billOfMaterialsPage.ManufOrderDispayed.getText().contains("Bills of Materials"), "Bills of Materials Button Verification Failed");
        //soft.assertTrue(locators.BillOfMaterials().isDisplayed(), "Bills of Materials Verification Failed");
        billOfMaterialsPage.CreateButton.click();
        Thread.sleep(2000);
        soft.assertTrue(billOfMaterialsPage.WindowDisplay.isDisplayed(), "Create button verification failed");
        List<WebElement> list1 = Driver.getDriver().findElements(By.xpath("//div[@class='o_cp_left']// button"));
        for (WebElement w: list1) {
            if(w.getText().equals("Save")){
                w.click();
                break;
            }

        }
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("(//td[@class='o_td_label']//label)[1]")).getAttribute("class").contains("invalid"), "Save button verification failed");

        soft.assertAll();


    }
    @Test(priority = 5)
    public void Gulmira_productSalesPrices(){

        LoginPage login = new LoginPage();
        ProductsPage product = new ProductsPage();
        product.productsButton.click();
        product.firstProduct.click();
        product.edit.click();
        product.sales.click();
        product.pointOfSales.click();
        soft = new SoftAssert();
        soft.assertTrue(product.pointOfSales.getText().equals("Point of Sale"), "failed");
        WebElement save = Driver.getDriver().findElement(By.xpath("//button[@accesskey='s']"));
        save.click();
        soft.assertAll();
    }

    @Test(priority = 6)
    public  void Gulmira_billOfMaterials()throws InterruptedException{
        BillOfMaterialPage bill = new BillOfMaterialPage();
        bill.billOfMaretialsButton.click();
        Thread.sleep(5000);
        List<WebElement> list = Driver.getDriver().findElements(By.cssSelector(".o_list_buttons button"));
        for (WebElement w: list) {
            if(w.getText().equals("Import")){
                w.click();
                break;
            }
        }
        Thread.sleep(5000);
        bill.loadFile.click();
        soft = new SoftAssert();
        soft.assertTrue(bill.billsOfMaterials.isDisplayed());
        soft.assertTrue(bill.loadFileButton.isEnabled());
        soft.assertAll();

    }

    @Test(priority = 8)
    public void David_CheckingTheCancelImports() throws InterruptedException {

        WebElement manufacturingButton = Driver.getDriver().findElement(By.linkText("Manufacturing"));
        manufacturingButton.click();
        Thread.sleep(3000);
        WebElement BillOfMaterials = Driver.getDriver().findElement(By.linkText("Bills of Materials"));
        BillOfMaterials.click();
        Thread.sleep(3000);
        WebElement InportButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_button_import']"));
        InportButton.click();
        Thread.sleep(1000);
        WebElement LoadFile = Driver.getDriver().findElement(By.xpath("//label[@class='btn btn-primary']"));
        LoadFile.click();
    }

    @AfterMethod
    public void close()
    {
//        driver.close();
//        driver = null;
        Driver.quitDriver();
    }




}
