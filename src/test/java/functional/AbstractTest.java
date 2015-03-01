package functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class AbstractTest {
    public Browser browser;

    @BeforeSuite
    public void initEnv()
    {
        File file = new File("d:\\Selenium\\chromedriver.exe");
        System.setProperty("webdriver.chrome.browser",file.getAbsolutePath());
        browser = new Browser(new FirefoxDriver());
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void shutEnv()
    {
        if (browser != null)
            browser.quit();
    }
}
