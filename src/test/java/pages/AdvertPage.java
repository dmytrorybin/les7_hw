package pages;

import entities.Advertisement;
import org.openqa.selenium.By;
import webdriver.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


/**
 * Created by eredin on 27.02.2015.
 */
public class AdvertPage extends AbstractPage {

    private static final By createAdvertisement = By.id("post-new-ad");

    private static final By advTitle = By.id("add-title");
    private static final By advCategory = By.id("targetrenderSelect1-0");
    private static final By categoryFirstStep = By.id("cat-891");
    private static final By categorySecondStep = By.cssSelector("a[data-category = '50']");
    private static final By categoryThirdStep = By.cssSelector("a[data-category = '547']");
    private static final By advPrice = By.className("paramPriceInput");
    private static final By advState = By.xpath(".//*[@id='targetparam13']/dt/a");
    private static final By chooseState = By.xpath(".//*[@id='targetparam13']/dd/ul/li[3]/a");
    private static final By advOwner = By.cssSelector("#targetid_private_business>dt>a");
    private static final By chooseOwner = By.xpath(".//*[@id='targetid_private_business']/dd/ul/li[2]/a");
    private static final By advDescription = By.id("add-description");
    private static final By advAddPic = By.id("add-file-1");
    private static final By advRegion = By.xpath(".//*[@id='targetregion-id-select']/dt/a");
    private static final By chooseRegion = By.xpath(".//*[@id='targetregion-id-select']/dd/ul/li[3]/a");
    private static final By advSubegion = By.xpath(".//*[@id='targetsubregion-id-select']/dt/a");
    private static final By chooseSubegion = By.xpath(".//*[@id='targetsubregion-id-select']/dd/ul/li[2]/a");
    private static final By advName = By.id("add-person");
    private static final By advEmail = By.id("add-email");
    private static final By advPhone = By.id("add-phone");
    private static final By advISQ = By.id("add-gg");
    private static final By advSkype = By.id("add-skype");
    private static final By advAcceptBox = By.cssSelector("label[relname = 'data[accept]']");
    private static final By prewiew = By.id("preview-link");

    private static final By prewiewBar = By.className("margin10_0");

    private static final By errTitle = By.cssSelector("label[for = 'add-title']");
    private static final By errPrice = By.cssSelector("label[for = 'data[param_price][1]']");
    private static final By errDesc = By.cssSelector("label[for = 'add-description']");
    private static final By errName = By.cssSelector("label[for = 'add-person']");
    private static final By errEmail = By.cssSelector("label[for = 'add-email']");
    private static final By errPhone = By.cssSelector("label[for = 'add-phone']");
    private static final By errICQ = By.cssSelector("label[for = 'add-gg']");
    private static final By errSkype = By.cssSelector("label[for = 'add-skype']");

    public AdvertPage(Browser driver) {
        super(driver);
    }

    public void newAdvert() {
        driver.findElement(createAdvertisement).click();
    }

    public void fillAdvert(Advertisement adv) {
        driver.findElement(advTitle).sendKeys(adv.title);
        driver.findElement(advCategory).click();

        driver.findElement(categoryFirstStep).click();
        driver.findElement(categorySecondStep).click();
        driver.findElement(categoryThirdStep).click();

        driver.findElement(advPrice).sendKeys(adv.price);

        driver.findElement(advState).click();
        driver.findElement(chooseState).click();

        driver.findElement(advOwner).click();
        driver.findElement(chooseOwner).click();

        driver.findElement(advDescription).sendKeys(adv.desc);

        driver.findElement(advAddPic).click();
        setClipboardData(adv.photoFilePath);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(advRegion).click();
        driver.findElement(chooseRegion).click();

        driver.findElement(advSubegion).click();
        driver.findElement(chooseSubegion).click();

        driver.findElement(advName).sendKeys(adv.name);
        driver.findElement(advEmail).sendKeys(adv.email);
        driver.findElement(advPhone).sendKeys(adv.phone);
        driver.findElement(advISQ).sendKeys(adv.icq);
        driver.findElement(advSkype).sendKeys(adv.skype);

        driver.findElement(advAcceptBox).click();
        driver.findElement(prewiew).click();
    }

    public boolean isOpened() {
        return driver.findElement(prewiewBar).isDisplayed();
    }

    public boolean isError()
    {
        if (driver.findElement(errTitle).isDisplayed() &&
            driver.findElement(errPrice).isDisplayed() &&
            driver.findElement(errDesc).isDisplayed() &&
            driver.findElement(errName).isDisplayed() &&
            driver.findElement(errEmail).isDisplayed() &&
            driver.findElement(errPrice).isDisplayed() &&
            driver.findElement(errICQ).isDisplayed() &&
            driver.findElement(errSkype).isDisplayed())
        {
            return true;
        }
        else
            return  false;
    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

    }
}
