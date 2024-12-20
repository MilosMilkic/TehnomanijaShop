import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BasePageTest {

    @Test
    public void verifySignUpPageLoads(){
        signUpPage.openSignUpPage();
        Assert.assertTrue(signUpPage.isSignUpPageOpen());
        Assert.assertEquals(signUpPage.getNewUserAccountText(), "Napravi novi korisnički nalog");
    }

    @Test
    public void verifyElementsPresent(){
        signUpPage.openSignUpPage();
        Assert.assertEquals(signUpPage.getPersonalDataText(), "Lični podaci");
        Assert.assertEquals(signUpPage.getSignUpInformationText(), "Podaci za prijavu");
        Assert.assertTrue(signUpPage.isFirstNameFieldDisplayed());
        Assert.assertTrue(signUpPage.isLastNameFiledDisplayed());
        Assert.assertFalse(signUpPage.isNewsletterCheckboxSelected());
        Assert.assertFalse(signUpPage.isPrivacyPolicyCheckboxSelected());
        Assert.assertTrue(signUpPage.isEmailFieldDisplayed());
        Assert.assertTrue(signUpPage.isPasswordFieldDisplayed());
        Assert.assertTrue(signUpPage.isConfirmPasswordFieldDisplayed());
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Nema lozinke");
        Assert.assertFalse(signUpPage.isCheckboxShowPasswordSelected());
        Assert.assertTrue(signUpPage.isCaptchaFieldDisplayed());
        Assert.assertTrue(signUpPage.isCaptchaImageDisplayed());
        Assert.assertTrue(signUpPage.isCaptchaReloadButtonDisplayed());
        Assert.assertTrue(signUpPage.isCreateAccountButtonDisplayed());
        Assert.assertEquals(signUpPage.getCreateAccountButtonText(), "Registracija");
    }


    @Test
    public void signUpWithValidCredentials(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        signUpPage.enterConfirmPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");

    }

    @Test
    public void signUpWithCaseInsensitiveEmail(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@Gmail.COM");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void signUpWithMinimumPasswordLength(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shop011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shop011!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Medium");
        signUpPage.enterConfirmPassword("Shop011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shop011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void signUpWithMaximumPasswordLength(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!Thinkpad!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        signUpPage.enterConfirmPassword("LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!LenovoThinkPad2024!Thinkpad!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void signUpWithPasswordContainingSpaces(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopp ing011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopp ing011!");
        signUpPage.enterConfirmPassword("Shopp ing011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopp ing011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void SignUpWithSpecialCharactersInFirstName(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("De'Luca");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void SignUpWithSpecialCharactersInLastName(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("O'Neill");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void signUpWithOneCharacterInFirstName(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("M");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }


    @Test
    public void signUpWithOneCharacterInLastName(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("R");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }

    @Test
    public void signUpWithEmailContainingSpecialCharacters(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner!1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://www.tehnomanija.rs/customer/account/");
    }


    @Test
    public void verifyEmailFieldTrimsTrailingSpaces(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com ");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.getEmailValue("mikirunner1@gmail.com"));
    }


    @Test
    public void verifyEmailFieldTrimsLeadingSpaces(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail(" mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.getEmailValue("mikirunner1@gmail.com"));
    }




    // Negative
    @Test
    public void signUpWithFirstNameFieldEmpty(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getFirstNameErrorMessage(), "Obavezno polje.");
    }

    @Test
    public void signUpWithLastNameFieldEmpty(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getLastNameErrorMessage(), "Obavezno polje.");
    }

    @Test
    public void signUpWithEmptyEmailField(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Obavezno polje.");
    }


    @Test
    public void signUpWithInvalidEmailFormat(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmali.cm");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).", "Fail: The user created an account and was redirected to the customer account page.");
    }

    @Test
    public void signUpWithInvalidEmailMissingAtSymbol(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void signUpWithInvalidEmailMissingDomain(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void signUpWithUnregisteredEmailDomain(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.uk1");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void signUpWithInvalidEmailContainingMultipleAtSymbols(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void signUpWithInvalidEmailWithSpaces(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner 1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //
        //    Assert.assertEquals(signUpPage.getEmailErrorMessage(), "Molimo Vas da unesete ispravnu email adresu (Ex: johndoe@domain.com).");
    }

    @Test
    public void signUpWithAlreadyRegisteredEmail(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        signUpPage.enterConfirmPassword("Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
    //    Assert.assertEquals(signUpPage.getRegisteredEmailErrorMessage(), "Već postoji nalog na našem sajtu povezan sa ovom e-mail adresom. Ukoliko je to Vaša adresa, kliknite ovde za restartovanje lozinke.");
    }

    @Test
    public void signUpWithEmptyPasswordField(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("");
        Assert.assertEquals(signUpPage.getPasswordValue(), "");
        signUpPage.enterConfirmPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopping011!");

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Nema lozinke");
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Obavezno polje.");
    }

   @Test
    public void signUpWithPasswordBelowMinimumLength(){
       signUpPage.openSignUpPage();
       signUpPage.enterFirstName("Miki");
       signUpPage.enterLastName("Runner");
       signUpPage.enterEmail("mikirunner1@gmail.com");
       signUpPage.enterPassword("Shop12!");
       Assert.assertEquals(signUpPage.getPasswordValue(), "Shop12!");
       signUpPage.enterConfirmPassword("Shop12!");
       Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shop12!");
       signUpPage.selectShowPasswordCheckbox();

       signUpPage.enterCaptchaText("");
       signUpPage.clickCreateAccountButton();
       Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Slaba");
       Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Dužina lozinke mora biti jednaka ili veća od 8 karaktera.");
   }

    @Test
    public void signUpWithPasswordWithoutNumber(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping!");
        signUpPage.enterConfirmPassword("Shopping!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopping!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Jaka");
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Minimum različitih znakova prilikom kreiranja lozinke je 3. Obavezni karakteri za kreiranje lozinke su: mala slova, velika slova, cifre, posebni znakovi.", "Fail: The user created an account and was redirected to the customer account page.");
    }

    @Test
    public void signUpWithPasswordWithoutUppercaseLetter(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("shopping011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "shopping011!");
        signUpPage.enterConfirmPassword("shopping011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Minimum različitih znakova prilikom kreiranja lozinke je 3. Obavezni karakteri za kreiranje lozinke su: mala slova, velika slova, cifre, posebni znakovi.", "Fail: The user created an account and was redirected to the customer account page.");
    }

    @Test
    public void signUpWithPasswordWithoutLowercaseLetter(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("SHOPPING011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "SHOPPING011!");
        signUpPage.enterConfirmPassword("SHOPPING011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "SHOPPING011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Minimum različitih znakova prilikom kreiranja lozinke je 3. Obavezni karakteri za kreiranje lozinke su: mala slova, velika slova, cifre, posebni znakovi.", "Fail: The user created an account and was redirected to the customer account page.");
    }

    @Test
    public void signUpWithPasswordWithoutSpecialCharacter(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping011");
        signUpPage.enterConfirmPassword("Shopping011");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopping011");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Minimum različitih znakova prilikom kreiranja lozinke je 3. Obavezni karakteri za kreiranje lozinke su: mala slova, velika slova, cifre, posebni znakovi.", "Fail: The user created an account and was redirected to the customer account page.");
    }

    @Test
    public void signUpWithEmptyConfirmPasswordField(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        signUpPage.enterConfirmPassword("");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordConfirmationError(), "Obavezno polje.");
    }


    @Test
    public void signUpWithNonMatchingPasswordAndConfirmPassword(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        signUpPage.enterConfirmPassword("Shopping1!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopping1!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordConfirmationError(), "Molimo Vas da ponovite lozinku.");
    }

    @Test
    public void signUpWithDifferentCaseInPasswordAndConfirmPassword(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        signUpPage.enterConfirmPassword("shopping011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordConfirmationError(), "Molimo Vas da ponovite lozinku.");
    }

    @Test
    public void signUpWithEmptyPasswordAndConfirmPasswordFields(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("");
        Assert.assertEquals(signUpPage.getPasswordValue(), "");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Nema lozinke");
        signUpPage.enterConfirmPassword("");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "");

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "Obavezno polje.");
        Assert.assertEquals(signUpPage.getPasswordConfirmationError(), "Obavezno polje.");
    }

    @Test
    public void signUpWithEmptyCaptcha(){
        signUpPage.openSignUpPage();
        signUpPage.enterFirstName("Miki");
        signUpPage.enterLastName("Runner");
        signUpPage.enterEmail("mikirunner1@gmail.com");
        signUpPage.enterPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordValue(), "Shopping011!");
        Assert.assertEquals(signUpPage.getPasswordStrengthMessage(), "Jačina lozinke: Veoma jaka");
        signUpPage.enterConfirmPassword("Shopping011!");
        Assert.assertEquals(signUpPage.getConfirmationPasswordValue(), "Shopping011!");
        signUpPage.selectShowPasswordCheckbox();

        signUpPage.enterCaptchaText("");
        signUpPage.clickCreateAccountButton();
        Assert.assertEquals(signUpPage.getCaptchaErrorMessage(), "Obavezno polje.");
    }



}
