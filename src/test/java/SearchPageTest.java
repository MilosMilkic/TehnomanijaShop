import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BasePageTest {

    @Test
    public void searchWithValidKeyword(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("Laptop");
        searchPage.clickOnSearchIcon();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/it-gaming/laptopovi");
        Assert.assertEquals(searchPage.getMainHeaderTitle(), "Laptopovi");
    }

    @Test
    public void searchWithValidMultipleKeywords(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("samsung tv");
        searchPage.clickOnSearchIcon();

        Assert.assertEquals(searchPage.getMainHeaderTitle(), "Rezultati pretrage: 'samsung tv'");
    }

    @Test
    public void searchWithCaseInsensitiveKeyword(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("Eksterni Hard disk");
        searchPage.clickOnSearchIcon();

        Assert.assertEquals(searchPage.getMainHeaderTitle(), "Rezultati pretrage: 'Eksterni Hard disk'");
    }

    @Test
    public void searchWithNumbersInKeyword(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("realme gt6");
        searchPage.clickOnSearchIcon();

        Assert.assertEquals(searchPage.getMainHeaderTitle(), "Rezultati pretrage: 'realme gt6'");
    }

    @Test
    public void searchWithAutocomplete(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("ipho");

        Assert.assertTrue(searchPage.isSuggestedSearchResultDisplayed());
    }

    @Test
    public void searchWithEmptyResults(){
        searchPage.openHomePage();
        searchPage.fillSearchField("");
        searchPage.keyPressEnter();

        Assert.assertEquals(searchPage.getSearchFieldPlaceholder(), "Pronađi proizvod, kategoriju ili brend");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/");
    }

    @Test
    public void searchWithSortingByPriceAscending(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("honor");
        searchPage.clickOnSearchIcon();
        searchPage.sortProductsByASC();

        Assert.assertEquals(searchPage.getMainHeaderTitle(), "Rezultati pretrage: 'honor'");
        Assert.assertEquals(searchPage.getProductPriceASC(), "1.099,00 RSD");
    }

    @Test
    public void searchWithSortingByPriceDescending(){
        searchPage.openHomePage();
        searchPage.clickOnSearchInputField();
        searchPage.fillSearchField("honor");
        searchPage.clickOnSearchIcon();
        searchPage.sortProductsByDSC();

        Assert.assertEquals(searchPage.getMainHeaderTitle(), "Rezultati pretrage: 'honor'");
        Assert.assertEquals(searchPage.getProductPriceDSC(), "149.999,00 RSD");
    }

}
