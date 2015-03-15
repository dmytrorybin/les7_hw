package pages;

import org.openqa.selenium.By;
import webdriver.Browser;


public class SearchPage extends AbstractPage {

    String searchName = "Caddy";
    private static final By searchField = By.id("headerSearch");
    private static final By submitButton = By.id("submit-searchmain");
    private static final By offers = By.className("offer");

    public SearchPage(Browser driver) {
        super(driver);
    }

    public void search()
    {
        driver.findElement(searchField).sendKeys(searchName);
        driver.findElement(submitButton).click();
    }

    public  boolean isOpened()
    {
        return driver.findElement(offers).getText().contains(searchName);
    }
}