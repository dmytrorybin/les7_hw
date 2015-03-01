//package pages;
//
//import org.openqa.selenium.By;
//import webdriver.Browser;
//
//
//public class SearchPage extends AbstractPage {
//    String searchName = "Volkswagen Caddy";
//
//    public SearchPage(Browser driver) {
//        super(driver);
//    }
//
//    public void search()
//    {
//        driver.findElement(By.id("headerSearch")).sendKeys(searchName);
//        driver.findElement(By.id("submit-searchmain")).click();
//      //  String foundName = driver.findElement(By.className("marginright5")).getText();
//    }
//
//    public  boolean isOpened()
//    {
//        boolean ok = false;
//        if (driver.findElement(By.className("marginright5")).getText().equalsIgnoreCase("Caddy"))
//            ok = true;
//        return ok;
//    }
//}