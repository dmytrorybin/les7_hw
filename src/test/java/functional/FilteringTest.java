package functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class FilteringTest extends AbstractTest{
    //    @Test
//    public  void searchTest()
//    {
//        searchItem();
//        SearchPage searchpage = new SearchPage(browser);
//        Assert.assertTrue(searchpage.isOpened());
//    }


    @Test
    public void newAdvertTest()
    {
        addNewAdvert();
        AdvertPage advert = new AdvertPage(browser);
        Assert.assertTrue( advert.isOpened());
    }


  //  @Test
    public void visualFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
    }

   // @Test
    public void priceFilterTest()
    {
        openDetskiyMir();
        openDetskayaOdezhda();
        sortByNew();
    }





    public void stateFilterTest ()
    {

    }

    public void sortByNew()
    {
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.sortByNew(), "Sorted by new ");
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

    public void addNewAdvert()
    {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        AdvertPage adverbpage = new AdvertPage(browser);
       // adverbpage.useJSTest();
        adverbpage.newAdvert();
        adverbpage.fillAdvert();
    }

//    public void searchItem()
//    {
//        HomePage homePage = new HomePage(browser);
//        homePage.open();
//        SearchPage searchpage = new SearchPage(browser);
//        searchpage.search();
//    }
}
