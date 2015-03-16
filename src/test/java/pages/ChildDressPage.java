package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

import java.util.List;


public class ChildDressPage extends AbstractPage {

    private boolean isOk;

    private static final By mainCategory = By.id("main-category-choose-label");
    private static final By stateDropownList = By.cssSelector("#param_state>div>a");
    private static final By detailsLink = By.cssSelector(".marginright5.link.linkWithHash." + "detailsLink>span");

    private static final By minPriceList = By.xpath(".//*[@id='param_price']/div/div[1]/a");
    private static final By minPriceEnter = By.className("min-value-input");
    private static final By maxPriceList = By.xpath(".//*[@id='param_price']/div/div[2]/a");
    private static final By maxPriceEnter = By.className("max-value-input");
    String minPrice = "100";
    String maxPrice = "500";

    private static final By submitButton = By.id("search-submit");
    private static final By elementsPriceList = By.cssSelector(".td-price>div>p>strong");
    private static final By elementsConditionList = By.cssSelector("a[title*='Нові']");

    String proofURL = "detskiy-mir/detskaya-odezhda/";
    String proofWord = "Дитячий одяг";

    public ChildDressPage(Browser driver) {
        super(driver);
    }


    public Boolean sortByNew() {
        driver.findElement(mainCategory).click();
        driver.findElement(stateDropownList).click();
        driver.findElement(detailsLink).click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  (new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Boolean ok = false;

      //  if (driver.findElement(elementsConditionList).getText().equalsIgnoreCase("Нові"))
       // if (driver.findElement(elementsConditionList).isDisplayed())
        if (driver.findElement(elementsConditionList).getText().contains("Нові"))
            ok = true;
        return ok;
    }


    public boolean sortByPrice() {
        driver.findElement(minPriceList).click();
        driver.findElement(minPriceEnter).sendKeys(minPrice);

        driver.findElement(maxPriceList).click();
        driver.findElement(maxPriceEnter).sendKeys(maxPrice);

        driver.findElement(submitButton).click();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    //    List<WebElement> elements = driver.findElements(elementsPriceList);

        boolean ok = false;
       // for (WebElement element : elements) {
        //    String string = element.getText();
        String string = driver.findElement(elementsPriceList).getText();
            int foundPrice = Integer.valueOf(string.substring(0, string.indexOf(" ")));
            if (foundPrice <= Integer.valueOf(maxPrice) && foundPrice >= Integer.valueOf(minPrice))
                ok = true;
      //  }
        return ok;
    }


    public boolean isOpened() {
        return (driver.getCurrentUrl().contains(proofURL)
                && driver.findElement(mainCategory).getText().contains(proofWord)
        );
    }
}
