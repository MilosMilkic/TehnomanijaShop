import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BasePageTest {

    @Test
    public void VerifyHomePageLoads(){
        homePage.openHomePage();

        Assert.assertTrue(homePage.isHomePageOpen());
        Assert.assertTrue(homePage.isHeaderDisplayed());
        Assert.assertTrue(homePage.isRandomBannerDisplayed());
        Assert.assertTrue(homePage.isSwiperSlideBrandProductsDisplayed());
        Assert.assertTrue(homePage.isSwiperSlideProductsDisplayed());
        Assert.assertTrue(homePage.isRecommendationProductsDisplayed());
        Assert.assertTrue(homePage.isPageFooterDisplayed());
        Assert.assertTrue(homePage.isFooterCardsDisplayed());
    }


    @Test
    public void verifyHeaderElementsPresent(){
        homePage.openHomePage();

        Assert.assertTrue(homePage.isLogoDisplayed());
        Assert.assertTrue(homePage.isAllCategoriesButtonDisplayed());

        Assert.assertTrue(homePage.isInputFieldDisplayed());
        Assert.assertTrue(homePage.getTextInputField(("Pronađi proizvod, kategoriju ili brend")));
        Assert.assertTrue(homePage.isSearchIconDisplayed());

        Assert.assertTrue(homePage.isSignInDisplayed());
        Assert.assertEquals(homePage.getTextFromElement("Prijava"), "Prijava");

        Assert.assertTrue(homePage.isWishListDisplayed());
        Assert.assertEquals(homePage.getTextFromElement("Lista želja"), "Lista želja");

        Assert.assertTrue(homePage.isShoppingCartDisplayed());
        Assert.assertEquals(homePage.getTextFromElement("Korpa"), "Korpa");
        Assert.assertEquals(homePage.getShoppingCartCounter(), "");

    }

    @Test
    public void verifyMenuElementsPresent(){
        homePage.openHomePage();

        Assert.assertTrue(homePage.isMenuElementDisplayed("Bela tehnika"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.appliances), "Bela tehnika");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Mali kućni aparati"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.smallAppliances), "Mali kućni aparati");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Klime i grejanje"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.airConditioningAndHeating), "Klime i grejanje");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Telefoni"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.telephones), "Telefoni");

        Assert.assertTrue(homePage.isMenuElementDisplayed("TV & AV"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.tvAndAv), "TV & AV");

        Assert.assertTrue(homePage.isMenuElementDisplayed("IT & Gaming"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.itAndGaming), "IT & Gaming");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Lepota i zdravlje"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.beautyAndHealthy), "Lepota i zdravlje");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Akcije i katalozi"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.promotions), "Akcije i katalozi");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Pravna lica"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.legalEntity), "Pravna lica");

        Assert.assertTrue(homePage.isMenuElementDisplayed("Podrška za potrošače"));
        Assert.assertEquals(homePage.getTextFromManuElement(homePage.customerSupport), "Podrška za potrošače");
    }


    @Test
    public void verifyAllCategoriesManuPresent(){
        homePage.openHomePage();
        homePage.clickOnAllCategories();

        Assert.assertTrue(homePage.isElementDisplayed("Bela tehnika"));
        Assert.assertEquals(homePage.getTextFromElement("Bela tehnika"), "Bela tehnika");

        Assert.assertTrue(homePage.isElementDisplayed("Mali kućni aparati"));
        Assert.assertEquals(homePage.getTextFromElement("Mali kućni aparati"), "Mali kućni aparati");

        Assert.assertTrue(homePage.isElementDisplayed("Klime, grejanje i kvalitet vazduha"));
        Assert.assertEquals(homePage.getTextFromElement("Klime, grejanje i kvalitet vazduha"), "Klime, grejanje i kvalitet vazduha");

        Assert.assertTrue(homePage.isElementDisplayed("TV, foto, audio i video"));
        Assert.assertEquals(homePage.getTextFromElement("TV, foto, audio i video"), "TV, foto, audio i video");

        Assert.assertTrue(homePage.isElementDisplayed("Telefoni, smart satovi i tableti"));
        Assert.assertEquals(homePage.getTextFromElement("Telefoni, smart satovi i tableti"), "Telefoni, smart satovi i tableti");

        Assert.assertTrue(homePage.isElementDisplayed("IT & Gaming"));
        Assert.assertEquals(homePage.getTextFromElement("IT & Gaming"),"IT & Gaming");

        Assert.assertTrue(homePage.isElementDisplayed("Lepota i zdravlje"));
        Assert.assertEquals(homePage.getTextFromElement("Lepota i zdravlje"), "Lepota i zdravlje");

        Assert.assertTrue(homePage.isElementDisplayed("Lifestyle"));
        Assert.assertEquals(homePage.getTextFromElement("Lifestyle"), "Lifestyle");

        Assert.assertTrue(homePage.isElementDisplayed("Kuća, bašta i alati"));
        Assert.assertEquals(homePage.getTextFromElement("Kuća, bašta i alati"), "Kuća, bašta i alati");

        Assert.assertTrue(homePage.isElementDisplayed("Auto-oprema"));
        Assert.assertEquals(homePage.getTextFromElement("Auto-oprema"), "Auto-oprema");

        Assert.assertTrue(homePage.isElementDisplayed("Bebe i deca"));
        Assert.assertEquals(homePage.getTextFromElement("Bebe i deca"), "Bebe i deca");

    }



    @Test
    public void verifyElementsClickable(){
        homePage.openHomePage();

        homePage.clickOnSignIn();
        Assert.assertTrue(homePage.isLoginPageOpen());
        homePage.navigateBack();

        homePage.clickOnWishlist();
        homePage.navigateBack();

        homePage.clickOnShoppingCart();
        Assert.assertEquals(homePage.cartMessage, homePage.getEmptyCartMessage());
        homePage.closeShoppingCartByX();

        homePage.clickOnLegalEntity();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/pages/pravna-lica");
        homePage.navigateBack();

        homePage.clickOnCustomerSupport();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/pages/kontakt");
        homePage.navigateBack();

        homePage.clickOnAllCategories();
        Assert.assertTrue(homePage.isAllCategoriesContainerDisplayed());
        homePage.closeAllCategoriesByX();

        homePage.clickOnLogo();
        Assert.assertTrue(homePage.isHomePageOpen());

        homePage.clickOnAppliances();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/bela-tehnika");
        homePage.navigateBack();

        homePage.clickOnSmallAppliances();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/mali-kucni-aparati");
        homePage.navigateBack();

        homePage.clickOnAirConditioningAndHeating();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/klime-grejanje-i-kvalitet-vazduha");
        homePage.navigateBack();

        homePage.clickOnTelephones();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/telefoni-smart-satovi-i-tableti");
        homePage.navigateBack();

        homePage.clickOnTvAndAv();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/tv-foto-audio-i-video");
        homePage.navigateBack();

        homePage.clickOnItAndGaming();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/it-gaming");
        homePage.navigateBack();

        homePage.clickOnBeautyAndHealthy();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/lepota-i-zdravlje");
        homePage.navigateBack();

        homePage.clickOnPromotions();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/akcije-i-katalozi");
        homePage.navigateBack();

    }


}
