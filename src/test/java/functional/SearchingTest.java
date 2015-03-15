package functional;

import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;

/**
 * Created by c267 on 11.03.2015.
 */
public class SearchingTest extends AbstractTest {


  //  @Test
    public void searchTest() {
        searchItem();
    }


    public void searchItem() {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        SearchPage searchpage = new SearchPage(browser);
        searchpage.search();
        Assert.assertTrue(searchpage.isOpened());
    }
}

