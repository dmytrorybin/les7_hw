package pages;

import webdriver.Browser;


public class AbstractPage {
    protected Browser driver;

    public AbstractPage(Browser driver) {
        this.driver = driver;
    }
}
