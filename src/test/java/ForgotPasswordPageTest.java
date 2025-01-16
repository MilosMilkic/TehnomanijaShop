import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class ForgotPasswordPageTest extends BasePageTest {


    @Test
    public void verifyForgotPageLoads(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.isForgotPasswordPageOpen();
        Assert.assertEquals(forgotPasswordPage.getHeaderText(), "Da li ste zaboravili svoju lozinku?");
        Assert.assertTrue(forgotPasswordPage.isPasswordInstructionMessageDisplayed());
        Assert.assertTrue(forgotPasswordPage.isEmailFieldDisplayed());
        Assert.assertTrue(forgotPasswordPage.isChangePasswordButtonDisplayed());
        Assert.assertEquals(forgotPasswordPage.getChangePasswordButtonText(),"Izmena lozinke");
    }

    @Test
    public void verifyResetPasswordWithValidEmail(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@gmail.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.tehnomanija.rs/customer/account/login/referer/aHR0cHM6Ly93d3cudGVobm9tYW5pamEucnMvY3VzdG9tZXIvYWNjb3VudC9pbmRleC8%2C/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.passwordResetMessage));
        Assert.assertTrue(forgotPasswordPage.isPasswordResetConfirmationMessageDisplayed());
        Assert.assertEquals(forgotPasswordPage.getPasswordResetConfirmationMessage(), "Ako postoji nalog koji je vezan za ovu email adresu, na istu ćete dobiti upustvo za promenu lozinke");

    }

    @Test
    public void verifyResetPasswordWithEmptyEmailField(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Obavezno polje.");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailContainingSpaces(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@ gmail.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailMissingAtSymbol(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1gmail.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailMissingDomain(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailFormat(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordUnregisteredEmailDomain(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@gmail.uk1");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailContainingMultipleAtSymbols(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@@gmail.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailContainingDotBeforeAtSymbol(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1.@gmail.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailDomainContainingConsecutiveDots(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@gmail..com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailWithoutDotInDomain(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@gmailcom");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void verifyResetPasswordWithInvalidEmailContainingSpecialCharacter(){
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.enterEmail("mikirunner1@gm#ail.com");
        forgotPasswordPage.clickChangePasswordButton();

        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }


}
