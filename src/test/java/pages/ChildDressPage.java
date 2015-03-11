package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.List;


public class ChildDressPage extends AbstractPage{

    private static final By mainCategory = By.id("main-category-choose-label");
    private static final By stateDropownList = By.cssSelector("#param_state>div>a");
    private static final By detailsLink = By.cssSelector(".marginright5.link.linkWithHash." + "detailsLink>span");

    private static final By minPriceList = By.xpath(".//*[@id='param_price']/div/div[1]/a");
    private static final By minPriceEnter = By.className("min-value-input");
    private static final By maxPriceList = By.xpath(".//*[@id='param_price']/div/div[2]/a");
    private static final By maxPriceEnter = By.className("max-value-input");

    private static final By submitButton = By.id("search-submit");

    private static final By elementsList = By.className("td-price");

    public ChildDressPage(Browser driver){super(driver);}

    public boolean isOpened(){
       return (driver.getCurrentUrl().contains("detskiy-mir/detskaya-odezhda/")
            && driver.findElement(mainCategory).getText().contains("Дитячий одяг")
        );
    }

    public Boolean sortByNew(){
        driver.findElement(mainCategory).click();
        driver.findElement(stateDropownList).click();
        driver.findElement(detailsLink).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("a"));
        Boolean ok = false;
        for (int i=0; i<elements.size(); i++)
            if (elements.get(i).getText().equalsIgnoreCase("Нові"))
                ok = true;
        driver.navigate().back();

        return ok;
    }

    public Boolean sortByPrice()
    {
        driver.findElement(minPriceList).click();
        driver.findElement(minPriceEnter).sendKeys("100");

        driver.findElement(maxPriceList).click();
        driver.findElement(maxPriceEnter).sendKeys("500");

        driver.findElement(submitButton).click();
        List<WebElement> elements = driver.findElements(elementsList);
        Boolean ok = false;
        for (int i=0; i<elements.size(); i++) {
            String string = elements.get(i).getText();
            if ((int) (Integer.parseInt(string)) < 500 && (int) (Integer.valueOf(string)) > 100)
                ok = true;
        }
        driver.navigate().back();

        return ok;

      //  driver.findElement(By.cssSelector(".marginright5.link.linkWithHash." +
      //          "detailsLink>span")).click();
    }


}
