package business.pages;

import core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /* *** Locators *** */

    /* Form header locator */
    private By formHeader = By.xpath("//mat-card-title");

    /*E-mail field related locators*/
    private By emailInputField = By.xpath("//label[contains(text(),\"email\")]/../preceding-sibling::input");
    private By emailInputFieldLabel = By.xpath("//label[contains(text(),\"email\")]");

    /* Password field related locators */
    private By passwordInputField = By.xpath("//label[contains(text(),\"password\")]/../preceding-sibling::input");
    private By passwordInputFieldLabel = By.xpath("//label[@id=\"mat-form-field-label-3\"]");

    /* Login & Sign Up button locators */
    private By loginButton = By.xpath("//span[text() = 'Login']/..");
    private By signUpButton = By.xpath("//span[text() = 'Sign up']/..");

    /* Error related locators*/
    private By loginErrorNotification = By.xpath("//app-snack/span");
    private By errorNotificationCloseButton = By.xpath("//app-snack/span/button");

    /* *** Methods *** */

    /* Get current url */
    public String getCurrentPageURl(){
        return getCurrentUrl();
    }

    /* Get form header text */
    public String getFormHeaderText(){
        return getText(formHeader);
    }

    /* Get emailInputField label */
    public String getInputFieldLabel(){
        return getText(emailInputFieldLabel);
    }

    /* Get passwordInputField label */
    public String getPasswordFieldLabel(){
        return getText(passwordInputFieldLabel);
    }

    /* Get error message text */
    public String getErrorMessage(){
        return getText(loginErrorNotification);
    }

    /* Fill email input field */
    public void fillInputField(String input){
        fill(emailInputField,input);
    }

    /* Fill password input field */
    public void fillPasswordField(String input){
        fill(passwordInputField,input);
    }

    /* Click login button */
    public void clickLoginButton(){
        click(loginButton);
    }

    /* Close the error message */
    public void closeErrorMessage(){
        click(errorNotificationCloseButton);
    }

    /* Is error message displayed */
    public boolean isErrorMessageDisplayed(){
        try{
            return isElementDisplayed(loginErrorNotification);
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
