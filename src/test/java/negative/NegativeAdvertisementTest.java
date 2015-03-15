package negative;

import entities.Advertisement;
import functional.AbstractTest;
import org.testng.Assert;
import pages.AdvertPage;
import pages.HomePage;


/**
 * Created by c246T on 02.03.2015.
 */
public class NegativeAdvertisementTest extends AbstractTest {


  // @Test
    public void createAdv() {
        addNewAdvert(false);
        AdvertPage advert = new AdvertPage(browser);
        Assert.assertTrue(advert.isErrorMessagesDisplayed());
    }


    public void addNewAdvert(boolean correct) {
        HomePage homePage = new HomePage(browser);
        homePage.open();

        Advertisement advertisement;
        if (correct) {
            advertisement = new Advertisement(true);
        } else {
            advertisement = new Advertisement(false);
        }
        AdvertPage advertpage = new AdvertPage(browser);
        advertpage.newAdvert();
        advertpage.fillAdvert(advertisement);
    }

}


