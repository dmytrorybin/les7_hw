package pages;

import org.openqa.selenium.By;
import webdriver.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


/**
 * Created by eredin on 27.02.2015.
 */
public class AdvertPage extends AbstractPage {

    public AdvertPage(Browser driver) {
        super(driver);
    }

    public void newAdvert() {
        driver.findElement(By.id("post-new-ad")).click();
    }

    public void fillAdvert() {
        driver.findElement(By.id("add-title")).sendKeys("My first advert");
        driver.findElement(By.id("targetrenderSelect1-0")).click();

        driver.findElement(By.id("cat-891")).click();
        driver.findElement(By.cssSelector("a[data-category = '50']")).click();
        driver.findElement(By.cssSelector("a[data-category = '547']")).click();

        driver.findElement(By.className("paramPriceInput")).sendKeys("100");

        // driver.findElement(By.id("targetparam13")).click();
        driver.findElement(By.xpath(".//*[@id='targetparam13']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetparam13']/dd/ul/li[3]/a")).click();

        // driver.findElement(By.id("targetid_private_business")).click();
        driver.findElement(By.cssSelector("#targetid_private_business>dt>a")).click();
        driver.findElement(By.xpath(".//*[@id='targetid_private_business']/dd/ul/li[2]/a")).click();

        driver.findElement(By.id("add-description")).sendKeys("this is description for my first advert. It must be at least 50 characters long.");

        driver.findElement(By.id("add-file-1")).click();
        ////////driver.findElement(By.name("image")).click();
        setClipboardData("C:\\_git\\lesson7_hw\\IMG_8101.JPG");
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

        driver.findElement(By.xpath(".//*[@id='targetregion-id-select']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetregion-id-select']/dd/ul/li[3]/a")).click();

        driver.findElement(By.xpath(".//*[@id='targetsubregion-id-select']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetsubregion-id-select']/dd/ul/li[2]/a")).click();

        driver.findElement(By.id("add-person")).sendKeys("Jacky Jackson");
        driver.findElement(By.id("add-email")).sendKeys("email@mail.com");
        driver.findElement(By.id("add-phone")).sendKeys("+380119876543");

        driver.findElement(By.cssSelector("label[relname = 'data[accept]']")).click();
        driver.findElement(By.id("preview-link")).click();
    }

    public boolean isOpened() {
        return driver.findElement(By.className("margin10_0")).isDisplayed();
    }


//    public void useJSTest() {
//        driver.get("http://hotline.ua/feedback/");
//        driver.findElement(By.name("image")).click();
//        setClipboardData("D:\\Selenium\\Code\\selenium-qa\\src\\test\\resources\\testng.xml");
//
//        Robot robot = null;
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        robot.setAutoDelay(900);
//
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//
//    }


    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

    }
}
