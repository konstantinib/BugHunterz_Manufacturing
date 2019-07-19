package bugHunterz_Manufacturing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class TestRunner {

    @Test
    public void CheckingTheCancelImports() {
        Driver.getDriver().get(Config.getProperty("url"));
        WebElement login = Driver.getDriver().findElement(By.id("login"));
        login.sendKeys(Config.getProperty("userName"));
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("kop98tfgQ68");
        WebElement logIn = Driver.getDriver().findElement(By.name("password"));
        logIn.submit();
        WebElement manufacturingButton = Driver.getDriver().findElement(By.linkText("Manufacturing"));
        manufacturingButton.click();
        WebElement BillOfMaterials = Driver.getDriver().findElement(By.linkText("Bills of Materials"));
        BillOfMaterials.click();
        WebElement InportButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-default o_button_import']"));
        InportButton.click();
        WebElement LoadFile = Driver.getDriver().findElement(By.xpath("//label[@class='btn btn-primary']"));
        LoadFile.click();
    }
}

