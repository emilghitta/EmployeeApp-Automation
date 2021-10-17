package tests.AppNavigation;

import business.messages.MainPageMessages;
import core.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BackNavigationTests extends TestUtilities {


    @Test(groups = "positiveBackNavigationTest")
    void navigateBackFromNewUserPageWithoutFormData() {
        log.info("Accessing the add new user page");
        page.mainPage.clickNewUserButton();

        log.info("Clicking on the back button");
        page.addOrEditEmployeePage.clickBackButton();


        log.info("Verify that we are on the correct page");
        Assert.assertTrue("We are not on the correct page",wait.until(ExpectedConditions.urlToBe(MainPageMessages.PAGE_URL)));
    }

    @Parameters({"firstName","lastName","invalidEmail","company","invalidPhone","invalidBirthDay"})
    @Test(groups = "positiveBackNavigationTest")
    void navigateBackFromNewUserPageWithFormData(String firstName,String lastName,String invalidEmail,String company, String invalidPhone, String invalidBirthday){
        log.info("Accessing the add new user page");
        page.mainPage.clickNewUserButton();

        log.info("Filling up the form with form data");
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,invalidEmail,company,invalidPhone,invalidBirthday);

        log.info("Clicking on the back button");
        page.addOrEditEmployeePage.clickBackButton();

        log.info("Verify that we are on the correct page");
        Assert.assertTrue("We are not on the correct page",wait.until(ExpectedConditions.urlToBe(MainPageMessages.PAGE_URL)));

    }
}
