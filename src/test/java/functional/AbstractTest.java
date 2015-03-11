package functional;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyLoader;
import webdriver.Browser;
import webdriver.BrowserFactory;


public class AbstractTest {
    public Browser browser;

    @BeforeSuite
    public void initEnv()
    {
        browser = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
    }

    @AfterSuite
    public void shutEnv()
    {
        if (browser != null)
            browser.quit();
    }
}
