import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }


        @FindBy(css = ".amsearch-input-wrapper .amsearch-input")
        WebElement searchInputField;
        @FindBy(css = "button[title='Clear Field']")
        WebElement clearSearchByX;
        @FindBy(css = ".amsearch-result-section")
        WebElement suggestedSearchResultSection;
        @FindBy(css = "button[title='Pretraži']")
        WebElement searchIcon;
        @FindBy(css = ".page-title span")
        WebElement titleHeading;
        @FindBy(css = "div[id='product-item-info_18933'] a[class='product-item-link']")
        WebElement searchProductResult;
        @FindBy(id = "sorter")
        WebElement sortProducts;
        @FindBy (id = "product-price-54688")
        WebElement honorProductPriceASC;
        @FindBy(id = "product-price-80158")
        WebElement honorProductPriceDSC;



        public boolean isSuggestedSearchResultDisplayed(){
            return suggestedSearchResultSection.isDisplayed();
        }


        public String getMainHeaderTitle(){
            return titleHeading.getText();
        }
        public String getSearchProductResult(){
            return searchProductResult.getText();
        }
        public String getSearchFieldPlaceholder(){return searchInputField.getAttribute("placeholder");}
        public String getProductPriceASC(){return honorProductPriceASC.getText();}
        public String getProductPriceDSC(){return honorProductPriceDSC.getText();}



        public void fillSearchField(String product){
            searchInputField.sendKeys(product);
        }
        public void clickOnSearchInputField(){
            searchInputField.click();
        }
        public void clickOnSearchIcon(){
            wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(searchIcon, "class", "-disabled")));
            searchIcon.click();
        }
        public void keyPressEnter(){
            searchIcon.sendKeys(Keys.ENTER);
         }

         public void sortProductsByASC(){
             Select select = new Select(sortProducts);
             select.selectByValue("price_asc");
         }

        public void sortProductsByDSC(){
            Select select = new Select(sortProducts);
            select.selectByValue("price_desc");
        }







        public void openHomePage(){
            driver.get("https://www.tehnomanija.rs/");
        };



    }








