package bugHunterz_Manufacturing;

import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class SaveButtonByNadia  {
    @Test
    public void logIn(){

        Driver.getDriver().get(Config.getProperty("url"));
    }
}
