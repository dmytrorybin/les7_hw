package functional;

import entities.Advertisement;
import org.testng.Assert;
import pages.*;


public class FilteringTest extends AbstractTest{

   //     @Test
    public  void searchTest()
    {
        searchItem();
        SearchPage searchpage = new SearchPage(browser);
        Assert.assertTrue(searchpage.isOpened());
    }


   // @Test
    public void newAdvertTest()
    {

        addNewAdvert(true);
        AdvertPage advert = new AdvertPage(browser);
        Assert.assertTrue( advert.isOpened());
    }


  //  @Test
    public void visualFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
    }

  //  @Test
    public void conditionFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
        sortByNew();
    }

   // @Test
    public void priceFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
        sortByPrice();
    }





    public void stateFilterTest ()
    {

    }

    public void sortByNew()
    {
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.sortByNew(), "Sorted by new ");
    }

    public void sortByPrice()
    {
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.sortByPrice(), "Sorted by price ");
    }

    public void openDetskiyMir()
    {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(browser);
        Assert.assertTrue(childPage.isOpened());
    }

    public void openDetskayaOdezhda()
    {
        ChildPage childPage = new ChildPage(browser);
        childPage.openOdezhda();
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.isOpened());
    }

    public void isPositive(boolean correct)
    {

    }

    public void addNewAdvert(boolean correct)
    {
        HomePage homePage = new HomePage(browser);
        homePage.open();

        Advertisement advertisement;
        if (correct == true) {
            advertisement = new Advertisement(true);
        }
        else {
           advertisement = new Advertisement(false);
        }
        AdvertPage advertpage = new AdvertPage(browser);
        advertpage.newAdvert();
        advertpage.fillAdvert(advertisement);
    }

    public void searchItem()
    {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        SearchPage searchpage = new SearchPage(browser);
        searchpage.search();
    }
}
