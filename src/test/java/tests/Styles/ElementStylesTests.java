package tests.Styles;

import business.messages.AddEditPageMessages;
import business.messages.HeaderPageMessages;
import core.TestUtilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementStylesTests extends TestUtilities {

    @Parameters({"firstName","lastName","invalidEmail","company","invalidPhone","invalidBirthDay"})
    @Test(groups = "addEmployeeStylesTesting")
    void addUserPageErrorMessageCheck(String firstName, String lastName, String invalidEmail, String company, String invalidPhone, String invalidBirthday){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + invalidEmail
                +" Company: " + company
                +" Phone: " + invalidPhone
                +" BirthDay: " + invalidBirthday
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,invalidEmail,company,invalidPhone,invalidBirthday);

        log.info("Clearing the first name input field");
        page.addOrEditEmployeePage.clearFirstNameField();

        log.info("Forcing error message to show");
        page.addOrEditEmployeePage.clearFirstNameField();
        page.addOrEditEmployeePage.clickEmailField();


        log.info("Verifying that the correct color is applied to the first name error label");
        softAssert.assertEquals(page.addOrEditEmployeePage.getFirstNameCSSColorValue(), AddEditPageMessages.LABEL_ERROR_MESSAGE_COLOR_HEX,"Incorrect color is applied to first name label");

        log.info("Clearing the last name input field");
        page.addOrEditEmployeePage.clearLastNameField();

        log.info("Forcing error message to show");
        page.addOrEditEmployeePage.clearLastNameField();
        page.addOrEditEmployeePage.clickEmailField();


        log.info("Verifying that the correct color is applied to the last name error label");
        softAssert.assertEquals(page.addOrEditEmployeePage.getLastNameCSSColorValue(),AddEditPageMessages.LABEL_ERROR_MESSAGE_COLOR_HEX,"Incorrect color is applied to last name label");

        log.info("Verifying that the correct color is applied to the e-mail error label");
        softAssert.assertEquals(page.addOrEditEmployeePage.getEmailCSSColorValue(), AddEditPageMessages.LABEL_ERROR_MESSAGE_COLOR_HEX,"Incorrect color is applied to e-mail label");

        log.info("Verifying that the correct color is applied to the phone error label");
        softAssert.assertEquals(page.addOrEditEmployeePage.getPhoneCSSColorValue(), AddEditPageMessages.LABEL_ERROR_MESSAGE_COLOR_HEX,"Incorrect color is applied to phone label");

        log.info("Verifying that the correct color is applied to the birth day error label");
        softAssert.assertEquals(page.addOrEditEmployeePage.getBirthDayCSSColorValue(), AddEditPageMessages.LABEL_ERROR_MESSAGE_COLOR_HEX,"Incorrect color is applied to birth day label");

        softAssert.assertAll();
    }

    @Test(groups = "headerStylesTesting")
    void headerPageStylesCheck(){
        log.info("Checking the h1 style");
        softAssert.assertEquals(page.headerPage.getH1color(),HeaderPageMessages.H1_COLOR,"H1 style is incorrect");

        log.info("Checking the matt toolbar background color");
        softAssert.assertEquals(page.headerPage.getMattToolbarBackgroundColor(),HeaderPageMessages.MATT_TOOLBAR_BACKGROUND_COLOR,"Matt toolbar background color is incorrect");

        log.info("Checking Logout Text color");
        softAssert.assertEquals(page.headerPage.getLogoutTextColor(),HeaderPageMessages.LOGOUT_TEXT_COLOR,"Logout text color is incorrect");

        log.info("Checking logout button background color");
        softAssert.assertEquals(page.headerPage.getLogoutButtonBackgroundColor(),HeaderPageMessages.LOGOUT_BACKGROUND_COLOR,"Logout button background color is incoorect");

        softAssert.assertAll();
    }
}
