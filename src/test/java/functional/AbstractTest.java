package functional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyLoader;
import webdriver.Browser;
import webdriver.BrowserFactory;


public class AbstractTest {
    public Browser browser;


    @BeforeClass
    public void initEnv()
    {
        browser = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
    }

    @AfterClass
    public void shutEnv()
    {
        if (browser != null)
            browser.quit();
    }
}
