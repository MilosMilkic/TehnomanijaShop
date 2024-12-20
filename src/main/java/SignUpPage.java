import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver){
        super(driver);
    }


    @FindBy(css = ".base")
    WebElement newUserAccountText;
    @FindBy(xpath = "//span[contains(text(),'Lični podaci')]")
    WebElement personalDataText;
    @FindBy(css = "#firstname")
    WebElement firstNameField;
    @FindBy(css = "#firstname-error")
    WebElement firstNameErrorMessage;
    @FindBy(css = "#lastname")
    WebElement lastNameField;
    @FindBy(css = "#lastname-error")
    WebElement lastNameErrorMessage;
    @FindBy(css = ".field.choice.newsletter")
    WebElement checkboxNewsletter;
    @FindBy(css = ".field.choice.privacy-policy input")
    WebElement checkboxPrivacyPolicy;


    @FindBy(xpath = "//span[normalize-space()='Podaci za prijavu']")
    WebElement signUpInformationText;
    @FindBy(css = "#email_address.input-text")
    WebElement emailField;
    @FindBy(css = "#email_address-error")
    WebElement emailAddressErrorMessage;
    @FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement registeredEmailErrorMessage;
    @FindBy(css = "#password.input-text")
    WebElement passwordField;
    @FindBy(css = "#password-strength-meter")
    WebElement passwordStrength;
    @FindBy(css = "#password-error")
    WebElement passwordErrorMessage;
    @FindBy(css = ".confirmation #password-confirmation")
    WebElement passwordConfirmationField;
    @FindBy(css = "#password-confirmation-error")
    WebElement passwordConfirmationError;
    @FindBy(css = "#show-password.checkbox")
    WebElement showPassword;
    @FindBy(css = ".captcha input")
    WebElement captchaField;
    @FindBy(className = "captcha-img")
    WebElement captchaImage;
    @FindBy(className = "captcha-reload")
    WebElement captchaReloadButton;
    @FindBy(css = "#captcha_user_create-error")
    WebElement captchaErrorMessage;
    @FindBy(css = ".primary .submit")
    WebElement createAccountButton;



    public String getNewUserAccountText(){ return newUserAccountText.getText();}
    public String getPersonalDataText(){ return personalDataText.getText();}
    public String getSignUpInformationText(){ return signUpInformationText.getText();}
    public String getPasswordStrengthMessage() { return passwordStrength.getText();}   //?
    public String getCreateAccountButtonText(){ return createAccountButton.getText();}
    public String getPasswordValue(){ return passwordField.getAttribute("value");}
    public String getConfirmationPasswordValue(){ return passwordConfirmationField.getAttribute("value");}
    public String getCaptchaErrorMessage(String captchaText){ return captchaErrorMessage.getText();}
    public String getFirstNameErrorMessage(){ return firstNameErrorMessage.getText();}
    public String getLastNameErrorMessage(){ return lastNameErrorMessage.getText();}
    public String getEmailErrorMessage(){ return emailAddressErrorMessage.getText();}
    public String getRegisteredEmailErrorMessage(){ return registeredEmailErrorMessage.getText();}
    public String getPasswordErrorMessage(){ return  passwordErrorMessage.getText();}
    public String getPasswordConfirmationError(){ return passwordConfirmationError.getText();}
    public String getCaptchaErrorMessage(){ return captchaErrorMessage.getText();}




    public boolean isFirstNameFieldDisplayed(){ return firstNameField.isDisplayed();}
    public boolean isLastNameFiledDisplayed(){ return lastNameField.isDisplayed();}
    public boolean isNewsletterCheckboxSelected(){ return checkboxNewsletter.isSelected();}
    public boolean isPrivacyPolicyCheckboxSelected(){ return checkboxPrivacyPolicy.isSelected();}
    public boolean isEmailFieldDisplayed(){ return emailField.isDisplayed();}
    public boolean isPasswordFieldDisplayed(){ return passwordField.isDisplayed();}
    public boolean isConfirmPasswordFieldDisplayed(){ return passwordConfirmationField.isDisplayed();}
    public boolean isCheckboxShowPasswordSelected(){ return showPassword.isSelected();}
    public boolean isCaptchaFieldDisplayed(){ return captchaField.isDisplayed();}
    public boolean isCaptchaImageDisplayed(){ return captchaImage.isDisplayed();}
    public boolean isCaptchaReloadButtonDisplayed(){ return captchaReloadButton.isDisplayed();}
    public boolean isCreateAccountButtonDisplayed(){ return createAccountButton.isDisplayed();}
    public boolean getEmailValue(String expectedValue) {
        String currentValue = emailField.getAttribute("value");
        return Objects.equals(currentValue, expectedValue);
    }



    public void enterFirstName(String name){firstNameField.sendKeys(name);}
    public void enterLastName(String lastName){lastNameField.sendKeys(lastName);}
    public void enterEmail(String email){emailField.sendKeys(email);}
    public void enterPassword(String password){passwordField.sendKeys(password);}
    public void enterConfirmPassword(String confirmPassword){passwordConfirmationField.sendKeys(confirmPassword);}
    public void selectShowPasswordCheckbox(){showPassword.click();}
    public void enterCaptchaText(String captchaText){captchaField.sendKeys(captchaText);}
    public void clickCreateAccountButton(){createAccountButton.submit();}



    String signUpPageURL = "https://www.tehnomanija.rs/customer/account/create/";

    public boolean isSignUpPageOpen(){
        String currentUrl = driver.getCurrentUrl();
        return Objects.equals(currentUrl, signUpPageURL);
    }

    public void openSignUpPage(){
        driver.get("https://www.tehnomanija.rs/customer/account/create/");
    }


}
