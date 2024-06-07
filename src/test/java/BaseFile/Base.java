package BaseFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Base {
    WebDriver driver;

    public WebDriver openBrowser(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.tehnomanija.rs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        driver = openBrowser();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
