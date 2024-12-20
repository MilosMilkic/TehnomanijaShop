import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }


    @FindBy(css = ".base")
    WebElement userLoginHeaderText;
    @FindBy(xpath = "//div[@class='login-container']//strong[@id='block-customer-login-heading']")
    WebElement registeredUsers;
    @FindBy(name = "login[username]")
    WebElement emailFieldInput;
    @FindBy(css = "#email-error")
    WebElement emailErrorMessage;
    @FindBy(name = "login[password]")
    WebElement passwordFieldInput;
    @FindBy(css = "#pass-error")
    WebElement passwordErrorMessage;
    @FindBy(css = ".choice #show-password")
    WebElement checkBoxShowPassword;
    @FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")
    WebElement loginButton;
    @FindBy(className = "remind")
    WebElement forgetPassword;
   // @FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    @FindBy(css = ".messages .message-error")
    WebElement loginErrorMessage;
    @FindBy(xpath = "//div[@class='login-container']//strong[@id='block-new-customer-heading']")
    WebElement newUserText;
    @FindBy(css = ".action.create.primary")
    WebElement registrationButton;



    public String getMainHeaderText(){return userLoginHeaderText.getText();}
    public String getRegisteredUsersText(){return registeredUsers.getText();}
    public String getLoginButtonText(){return loginButton.getText();}
    public String getForgetPasswordText(){return forgetPassword.getText();}
    public String getNewUserText(){return newUserText.getText();}
    public String getRegistrationButtonText(){return registrationButton.getText();}
    public String getEmailErrorMessage(){return emailErrorMessage.getText();}
    public String getPasswordErrorMessage(){return passwordErrorMessage.getText();}
    public String getLoginErrorMessage(){return loginErrorMessage.getText();}


    public boolean isEmailFieldDisplayed(){return emailFieldInput.isDisplayed();}
    public boolean isPasswordFieldDisplayed(){return passwordFieldInput.isDisplayed();}
    public boolean isShowPasswordCheckboxDisplayed(){return checkBoxShowPassword.isDisplayed();}
    public boolean isLoginButtonDisplayed(){return loginButton.isDisplayed();}
    public boolean isShowPasswordCheckboxSelected(){return checkBoxShowPassword.isSelected();}
    public boolean isForgetPasswordLinkDisplayed(){return forgetPassword.isDisplayed();}
    public boolean isRegistrationButtonDisplayed(){return registrationButton.isDisplayed();}



    public void clickOnRegistrationButton(){ registrationButton.click();}
    public void selectShowPasswordCheckBox(){checkBoxShowPassword.click();}
    public void enterEmail(String email){emailFieldInput.sendKeys(email);}
    public void enterPassword(String password){passwordFieldInput.sendKeys(password);}
    public void clickOnLoginButton(){loginButton.submit();}
    public void clickOnForgotPassword(){forgetPassword.click();}



    String loginPageURL = "https://www.tehnomanija.rs/customer/account/login//";

    public boolean isLoginPageOpen(){
        String currentUrl = driver.getCurrentUrl();
        return Objects.equals(currentUrl, loginPageURL);
    }

    public void openLoginPage(){
        driver.get("https://www.tehnomanija.rs/customer/account/login//");
    }

}
