import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasePageTest {

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    ForgotPasswordPage forgotPasswordPage;

    WebDriverWait wait;

    WebDriver driver;
    public WebDriver openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }


    @BeforeMethod
    public void setUp(){
        driver = openBrowser();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);


    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
