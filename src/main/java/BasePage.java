import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



public class BasePage {

    public JavascriptExecutor js;
    public Actions action;


    public void scrollingToView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToTheTop() {
        js.executeScript("window.scrollBy(0,-250)", "");
    }

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

}
