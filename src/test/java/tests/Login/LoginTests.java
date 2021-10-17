package tests.Login;

import business.messages.LoginPageMessages;
import business.messages.MainPageMessages;
import core.TestUtilities;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTests extends TestUtilities {


    @Parameters({"positiveEmail","positivePassword"})
    @Test(groups = {"positiveLoginTest"})
    void positiveLoginTest(String validEmail, String validPassword){
        log.info("Performing login flow with the following credentials: " +
                "username " + validEmail +
                " and password: " + validPassword);
        page.loginFlow.authenticate(validEmail,validPassword);

        log.info("Verify that the correct welcome header is displayed");
        Assert.assertEquals("Incorrect welcome header is displayed",MainPageMessages.WELCOME_MESSAGE + validEmail,page.mainPage.getWelcomeMessage());
    }

    @Parameters({"negativeEmail","positivePassword"})
    @Test(groups = {"invalidEmailLoginTest"})
    void invalidEmailLoginTest(String invalidEmail, String validPassword) throws InterruptedException {
        log.info("Performing login flow with the following invalid credentials: " +
                "Username: " + invalidEmail+
                " and password: " + validPassword);

        page.loginFlow.authenticate(invalidEmail,validPassword);

        log.info("Verify that the login error message is displayed");
        Assert.assertTrue("Login error message is not displayed when it should",page.loginPage.isErrorMessageDisplayed());

        log.info("Verify that the correct error message is displayed");
        Assert.assertTrue("Incorrect error message is displayed",page.loginPage.getErrorMessage().contains(LoginPageMessages.Login_ERROR_MESSAGE));
    }

    @Parameters({"positiveEmail","negativePassword"})
    @Test(groups = {"invalidPasswordLoginTest"})
    void invalidPasswordLoginTest(String validEmail,String invalidPassword){
        log.info("Performing login flow with the following invalid credentials: "+
                "Username: " + validEmail +
                " and password: " +invalidPassword);
        page.loginFlow.authenticate(validEmail,invalidPassword);

        log.info("Verify that the login error message is displayed");
        Assert.assertTrue("The login error message is not displayed when it should",page.loginPage.isErrorMessageDisplayed());

        log.info("Verify that the correct error message is displayed");
        Assert.assertTrue("Incorrect error message is displayed",page.loginPage.getErrorMessage().contains(LoginPageMessages.Login_ERROR_MESSAGE));

    }
}
