package tests.Logout;

import business.messages.LoginPageMessages;
import core.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LogoutTests extends TestUtilities {


    @Test(groups = "positiveLogoutTest")
    void logoutFromMainPage(){
        log.info("Clicking the logout button");
        page.headerPage.clickLogoutButton();

        log.info("Verify that we are back on the login page");
        Assert.assertTrue("We are not on the correct page",wait.until(ExpectedConditions.urlToBe(LoginPageMessages.PAGE_URL)));

    }

    @Test(groups = "positiveLogoutTest")
    void logoutFromAddEmployeePage(){
        log.info("Accessing the add Employee page");
        page.mainPage.clickNewUserButton();

        log.info("Clicking the logout button");
        page.headerPage.clickLogoutButton();

        log.info("Verify that we are back on the login page");
        Assert.assertTrue("We are not on the correct page",wait.until(ExpectedConditions.urlToBe(LoginPageMessages.PAGE_URL)));
    }
}
