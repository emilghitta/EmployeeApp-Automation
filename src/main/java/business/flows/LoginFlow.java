package business.flows;

import business.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginFlow extends LoginPage {
    public LoginFlow(WebDriver driver) {
        super(driver);
    }

    /* Login flow with form submission */
    public void authenticate(String email, String password){
        fillInputField(email);
        fillPasswordField(password);
        clickLoginButton();
    }

}
