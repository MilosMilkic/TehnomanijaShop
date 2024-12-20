import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest{

    @Test
    public void verifyLoginPageLoads(){
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.isLoginPageOpen());
        Assert.assertEquals(loginPage.getMainHeaderText(), "Prijava korisnika");

    }

    @Test
    public void verifyRegisteredUserUIElementsPresent(){
        loginPage.openLoginPage();
        Assert.assertEquals(loginPage.getRegisteredUsersText(), "Registrovani korisnici");
        Assert.assertTrue(loginPage.isEmailFieldDisplayed());
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
        Assert.assertTrue(loginPage.isShowPasswordCheckboxDisplayed());
        Assert.assertFalse(loginPage.isShowPasswordCheckboxSelected());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        Assert.assertEquals(loginPage.getLoginButtonText(), "Prijava");
        Assert.assertTrue(loginPage.isForgetPasswordLinkDisplayed());
        Assert.assertEquals(loginPage.getForgetPasswordText(), "Da li ste zaboravili svoju lozinku?");
    }

    @Test
    public void verifyNewUserUIElementsPresent(){
        loginPage.openLoginPage();
        Assert.assertEquals(loginPage.getNewUserText(), "Novi korisnik");
        Assert.assertTrue(loginPage.isRegistrationButtonDisplayed());
        Assert.assertEquals(loginPage.getRegistrationButtonText(), "Registracija");
    }

    @Test
    public void verifyRegistrationButtonClickable(){
        loginPage.openLoginPage();
        loginPage.clickOnRegistrationButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/customer/account/create/");
    }

    @Test
    public void navigateToForgotPasswordPage(){
        loginPage.openLoginPage();
        loginPage.clickOnForgotPassword();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/forgotpassword/");
    }

    @Test
    public void loginWithValidCredentials(){
        loginPage.openLoginPage();
        loginPage.enterEmail("mikirunner1@gmail.com");
        loginPage.enterPassword("Shopping011!");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void loginWithCaseInsensitiveEmail(){
        loginPage.openLoginPage();
        loginPage.enterEmail("MikiRunner1@gmail.com");
        loginPage.enterPassword("Shopping011!");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void loginWithEmailContainingSpacesAndValidPassword(){
        loginPage.openLoginPage();
        loginPage.enterEmail("miki runner1@gmail.com");
        loginPage.enterPassword("Shopping011!");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "E-mail adresa ili lozinka nisu ispravni. Pokušaj ponovo.");
    }

    @Test
    public void loginWithEmptyEmailAndValidPassword(){
        loginPage.openLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("Shopping011!");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Obavezno polje.");
    }

    @Test
    public void loginWithInvalidEmailAndValidPassword(){
        loginPage.openLoginPage();
        loginPage.enterEmail("mikirunner1gmail.com");
        loginPage.enterPassword("Shopping011!");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void loginWithUnregisteredEmailAndValidPassword(){
        loginPage.openLoginPage();
        loginPage.enterEmail("mikirunner51@gmail.com");
        loginPage.enterPassword("Shopping011!");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "E-mail adresa ili lozinka nisu ispravni. Pokušaj ponovo.");
    }

    @Test
    public void loginWithUnregisteredEmailAndInvalidPassword(){
        loginPage.openLoginPage();
        loginPage.enterEmail("mikirunner51@gmail.com");
        loginPage.enterPassword("purchase");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "E-mail adresa ili lozinka nisu ispravni. Pokušaj ponovo.");
    }

    @Test
    public void loginWithEmptyPasswordAndValidEmail(){
        loginPage.openLoginPage();
        loginPage.enterEmail("mikirunner1@gmail.com");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Obavezno polje.");
    }

    @Test
    public void loginWithInvalidPasswordAndValidEmail(){
        loginPage.openLoginPage();
        loginPage.enterEmail("mikirunner1@gmail.com");
        loginPage.enterPassword("Shopping");
        loginPage.selectShowPasswordCheckBox();
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "E-mail adresa ili lozinka nisu ispravni. Pokušaj ponovo.");
    }



}
