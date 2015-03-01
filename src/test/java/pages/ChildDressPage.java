package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.List;


public class ChildDressPage extends AbstractPage{

    public ChildDressPage(Browser driver){super(driver);}

    public boolean isOpened(){
       return (driver.getCurrentUrl().contains("detskiy-mir/detskaya-odezhda/")
            && driver.findElement(By.id("main-category-choose-label")).getText().contains("Дитячий одяг")
        );
    }

    public Boolean sortByNew(){
        driver.findElement(By.cssSelector("#param_state>div>a")).click();
        driver.findElement(By.cssSelector("#f-new_state")).click();
        driver.findElement(By.cssSelector(".marginright5.link.linkWithHash." +
                "detailsLink>span")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("a"));
        Boolean ok = false;
        for (int i=0; i<elements.size(); i++)
            if (elements.get(i).getText().equalsIgnoreCase("Нові"))
                ok = true;
        driver.navigate().back();

        return ok;
    }


}
