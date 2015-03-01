package pages;

import org.openqa.selenium.By;
import webdriver.Browser;


public class ChildPage extends AbstractPage{
    private static final By openDetskayaOdezhdaLink = By.id("cat-539");

    public ChildPage(Browser driver) {
        super(driver);
    }

    public void openOdezhda()
    {
        driver.findElement(openDetskayaOdezhdaLink).click();
    }

    public boolean isOpened()
    {
        return driver.findElement(openDetskayaOdezhdaLink).isDisplayed();
    }
}
