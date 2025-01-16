import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }


    @FindBy(css = ".page-title .base")
    WebElement forgotPasswordHeaderText;

    @FindBy(css = ".field.note")
    WebElement passwordResetInstructionMessage;

    @FindBy(css = "#email_address")
    WebElement emailField;

    @FindBy(css = "#email_address-error")
    WebElement emailErrorMessage;

    @FindBy (css = "#send2")
    WebElement changePasswordButton;

    @FindBy(css = ".page.messages")
    WebElement passwordResetMessage;



    public String getHeaderText(){
        return forgotPasswordHeaderText.getText();
    }
    public String getChangePasswordButtonText(){
        return changePasswordButton.getText();
    }
    public String getEmailValue(){
        return emailField.getAttribute("value");
    }
    public String getPasswordResetConfirmationMessage(){
        return passwordResetMessage.getText();
    }
    public String getEmailErrorMessage(){
        return emailErrorMessage.getText();
    }


    public boolean isPasswordInstructionMessageDisplayed(){
        return passwordResetInstructionMessage.isDisplayed();
    }
    public boolean isEmailFieldDisplayed(){
        return emailField.isDisplayed();
    }
    public boolean isChangePasswordButtonDisplayed(){
        return changePasswordButton.isDisplayed();
    }
    public boolean isPasswordResetConfirmationMessageDisplayed(){
        return passwordResetMessage.isDisplayed();
    }


    public void enterEmail(String email){
        emailField.sendKeys(email);
    }
    public void clickChangePasswordButton(){
        changePasswordButton.submit();
    }




    String forgotPasswordPageURL = "https://www.tehnomanija.rs/customer/account/forgotpassword/";
    public boolean isForgotPasswordPageOpen(){
        String currentUrl = driver.getCurrentUrl();
        return Objects.equals(currentUrl, forgotPasswordPageURL);

    }
    public void openForgotPasswordPage(){driver.get("https://www.tehnomanija.rs/customer/account/forgotpassword/");}

}
