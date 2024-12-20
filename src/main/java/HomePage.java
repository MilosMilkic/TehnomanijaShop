import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    // Home Page Assert
    @FindBy(id = "ammenu-header-container")
    WebElement getHeaderPage;
    @FindBy(className = "change_baner_random")
    WebElement getChangeRandomBanner;
    @FindBy(className = "swiper-container-pay-cat")
    WebElement getSwiperSlideBrandProducts;
    @FindBy(className = "selected_category")
    WebElement getSwiperSlideProducts;
    @FindBy(css = ".home_four_products .block-products-list")
    WebElement getProductsOurRecommendation;
    @FindBy(className = "page-footer")
    WebElement getPageFooter;
    @FindBy(className = "footer_cards")
    WebElement getFooterCards;

    // Header
    @FindBy(className = "authorization-link")
    WebElement signIn;
    @FindBy(xpath = "//a[contains(text(),'Lista želja')]")
    WebElement wishlist;
    @FindBy(className = "showcart")
    WebElement shoppingCart;
    @FindBy (id = "btn-minicart-close")
    WebElement closeShoppingCart;
    @FindBy(css = ".showcart .counter")
    WebElement shoppingCartCounter;
    @FindBy(className = "empty_cart_message")
    WebElement emptyCartMessage;
    @FindBy(css = ".amsearch-input-wrapper .amsearch-input")
    WebElement inputField;
    @FindBy(css = "button[title='Clear Field']")
    WebElement clearSearchByX;
    @FindBy(css = ".amsearch-result-section .amsearch-message-block")
    WebElement searchResultSection;
    @FindBy(css = "button[title='Pretraži']")
    WebElement searchIcon;
    @FindBy(className = "ammenu-logo")
    WebElement logo;
    //@FindBy(css = ".ammenu-button.-hamburger.-trigger")
    @FindBy(xpath = "//button[@class='ammenu-button -hamburger -trigger']")
    WebElement allCategories;
    @FindBy(css = ".ammenu-button.-hamburger.-trigger.active_btn")
    WebElement closeAllCategories;
    @FindBy(className = "back-to-top")
    WebElement backToTop;

    // Menu
    @FindBy(css = ".far.fa-home-lg-alt")
    WebElement homeIcon;
    @FindBy(css = "a[href='/bela-tehnika']")
    WebElement appliances;
    @FindBy(css = "a[href='/mali-kucni-aparati']")
    WebElement smallAppliances;
    @FindBy(css = "a[href='/klime-grejanje-i-kvalitet-vazduha']")
    WebElement airConditioningAndHeating;
    @FindBy(css = "a[href='/telefoni-smart-satovi-i-tableti']")
    WebElement telephones;
    @FindBy(css = "a[href='/tv-foto-audio-i-video']")
    WebElement tvAndAv;
    @FindBy(css = "a[href='/it-gaming']")
    WebElement itAndGaming;
    @FindBy(css = "a[href='/lepota-i-zdravlje']")
    WebElement beautyAndHealthy;
    @FindBy(linkText = "Akcije i katalozi")
    WebElement promotions;
    @FindBy(css = "ul[class='h_contact'] li:nth-child(1) a:nth-child(1)")
    WebElement legalEntity;
    @FindBy(css = "a[href='/pages/kontakt']")
    WebElement customerSupport;
    @FindBy(css = ".h_header_links li a")
    List<WebElement> headerManu;

    // All categories / hamburger menu
    @FindBy (className = "ammenu-main-container")
    WebElement allCategoriesContainer;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/bela-tehnika']")
    //  @FindBy(xpath = "//span[normalize-space()='Bela tehnika']")
    WebElement appliancesMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/mali-kucni-aparati']")
    WebElement smallAppliancesMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/klime-grejanje-i-kvalitet-vazduha']")
    WebElement airConditioningHeatingMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/tv-foto-audio-i-video']")
    WebElement tvPhotoAudioAndVideoMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/telefoni-smart-satovi-i-tableti']")
    WebElement telephonesSmartWatchesTabletsMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/it-gaming']")
    WebElement itAndGamingMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/lepota-i-zdravlje']")
    WebElement beautyAndHealthyMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/lifestyle']")
    WebElement lifestyleMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/kuca-basta-i-alati']")
    WebElement houseGardenToolsMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/auto-oprema']")
    WebElement carEquipmentMenu;
    @FindBy(css = ".ammenu-link[if='item.isVisible'][href='https://www.tehnomanija.rs/bebe-i-deca']")
    WebElement babyAndChildrenMenu;




    String homePageURL = "https://www.tehnomanija.rs/";
    String loginPageURL = "https://www.tehnomanija.rs/customer/account/login/referer/aHR0cHM6Ly93d3cudGVobm9tYW5pamEucnMv/";
    String cartMessage = "VAŠA KORPA JE PRAZNA. POGLEDAJTE PROIZVODE NA AKCIJI I NARUČITE VEĆ DANAS.";

    public void navigateBack() {driver.navigate().back();}

    public boolean isHomePageOpen(){
        String currentUrl = driver.getCurrentUrl();
        return Objects.equals(currentUrl, homePageURL);
    }

    public boolean isLoginPageOpen(){
        String currentUrl = driver.getCurrentUrl();
        return Objects.equals(currentUrl, loginPageURL);
    }


    // Assert Home Page
    public boolean isHeaderDisplayed(){
        return getHeaderPage.isDisplayed();
    }
    public boolean isRandomBannerDisplayed(){
        return getChangeRandomBanner.isDisplayed();
    }
    public boolean isSwiperSlideBrandProductsDisplayed(){
        return getSwiperSlideBrandProducts.isDisplayed();
    }
    public boolean isSwiperSlideProductsDisplayed(){
        return getSwiperSlideProducts.isDisplayed();
    }
    public boolean isRecommendationProductsDisplayed(){
        return getProductsOurRecommendation.isDisplayed();
    }
    public boolean isPageFooterDisplayed(){
        return getPageFooter.isDisplayed();
    }
    public boolean isFooterCardsDisplayed(){
        return getFooterCards.isDisplayed();
    }



    // Assert Header
    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }
    public boolean isAllCategoriesButtonDisplayed(){
        return allCategories.isDisplayed();
    }
    public boolean isInputFieldDisplayed(){
        return inputField.isDisplayed();
    }
    public boolean isSearchIconDisplayed(){
        return searchIcon.isDisplayed();
    }
    public boolean isSignInDisplayed(){
        return signIn.isDisplayed();
    }
    public boolean isWishListDisplayed(){
        return wishlist.isDisplayed();
    }
    public boolean isShoppingCartDisplayed(){
        return shoppingCart.isDisplayed();
    }
    public boolean isAllCategoriesContainerDisplayed(){
        return allCategoriesContainer.isDisplayed();
    }
    public boolean getSearchFieldPlaceholder(String element){return Objects.equals(inputField.getAttribute("placeholder"), element);}



    public boolean isElementDisplayed(String elementName) {
        List<WebElement> elList = List.of(appliancesMenu, smallAppliancesMenu,
                airConditioningHeatingMenu, tvPhotoAudioAndVideoMenu, telephonesSmartWatchesTabletsMenu,
                itAndGamingMenu, beautyAndHealthyMenu, lifestyleMenu, houseGardenToolsMenu,
                carEquipmentMenu, babyAndChildrenMenu);

        for (WebElement elem : elList) {
            if (elem.isDisplayed() && elem.getText().equals(elementName)) {
                return true;
            }
        }
        return false;
    }


    public String getTextFromElement(String elementName) {
        List<WebElement> elementsList = List.of(signIn, wishlist, shoppingCart, appliancesMenu,
                smallAppliancesMenu, airConditioningHeatingMenu, tvPhotoAudioAndVideoMenu,
                telephonesSmartWatchesTabletsMenu, itAndGamingMenu, beautyAndHealthyMenu,
                lifestyleMenu, houseGardenToolsMenu, carEquipmentMenu, babyAndChildrenMenu);

        return elementsList.stream()
                .filter(item -> item.isDisplayed() && item.getText().equals(elementName))
                .findFirst()
                .map(WebElement::getText)
                .orElse("No matches");
    }



    public boolean isMenuElementDisplayed(String elementName) {
        for (WebElement elem : headerManu) {
            if (elem.isDisplayed() && elem.getText().equals(elementName)) {
                return true;
            }
        }
        return false;
    }

    public String getTextFromManuElement(WebElement element) {
        return headerManu.stream()
                .filter(elem -> elem.isDisplayed() && elem.getText().equals(element.getText()))
                .findFirst()
                .map(WebElement::getText)
                .orElse("No matches");
    }


    public void clickOnShoppingCart() {shoppingCart.click();}

    public void closeShoppingCartByX(){closeShoppingCart.click();}

    public String getShoppingCartCounter(){
        return shoppingCartCounter.getText();
    }

    public String getEmptyCartMessage() {
        if (Objects.equals(cartMessage, emptyCartMessage.getText())) {
            return cartMessage;
        } else {
            return "Your cart contains products";
        }
    }




    public void clickOnAllCategories() {allCategories.click();}

    public void closeAllCategoriesByX(){closeAllCategories.click();}

    public void clickOnLogo() {logo.click();}

    public void clickOnSignIn() {signIn.click();}

    public void clickOnWishlist() {wishlist.click();}

    public void clickOnAppliances() {appliances.click();}

    public void clickOnSmallAppliances() {smallAppliances.click();}

    public void clickOnAirConditioningAndHeating() {airConditioningAndHeating.click();}

    public void clickOnTelephones() {telephones.click();}

    public void clickOnTvAndAv() {tvAndAv.click();}

    public void clickOnItAndGaming() {itAndGaming.click();}

    public void clickOnBeautyAndHealthy() {beautyAndHealthy.click();}

    public void clickOnPromotions() {promotions.click();}

    public void clickOnLegalEntity() {legalEntity.click();}

    public void clickOnCustomerSupport(){customerSupport.click();}





    public void openHomePage(){
        driver.get("https://www.tehnomanija.rs/");
    }




}
