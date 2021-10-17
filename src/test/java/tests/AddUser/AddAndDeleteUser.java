package tests.AddUser;

import core.TestUtilities;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddAndDeleteUser extends TestUtilities {

    @Parameters({"firstName","lastName","validMail","company","phone","validBirthDay"})
    @Test(groups = {"positiveAddUserTest"})
    void addNewUser(String firstName, String lastName,String validMail,
                    String company,String phone, String validBirthDay) {

        log.info("Getting initial table row length");
        int tableRowLength = page.mainPage.getTableRowNumbers();

        page.mainPage.setUniqueFirstName(firstName + uniqueIdentificator);

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Creating a new user with:" +
                " firstName: " + page.mainPage.getUniqueFirstName()
                +" lastName: " + lastName
                +" E-mail: " + validMail
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + validBirthDay
        );
        page.addEmployeeFlow.addUser(page.mainPage.getUniqueFirstName(),lastName,validMail,company,phone,validBirthDay);

        log.info("Verify that the table row length has increased");
        Assert.assertEquals("The table row length was not increased when it should have",tableRowLength + 1,page.mainPage.getTableRowNumbers());

        log.info("Verify that the new table entry was added successfully based on firstName");
        Assert.assertTrue("The new table entry was not added successfully",page.mainPage.findUniqueElementInTable());

    }

    @Test(groups = {"userDeletion"},dependsOnMethods = {"addNewUser"})
    void deleteUser(){


        int tableRowLength = page.mainPage.getTableRowNumbers();

        log.info("Deleting the newly created user");
        page.mainPage.deleteTableEntry();

        log.info("Confirming the item deletion");
        page.mainPage.clickConfirmationYesButton();

        log.info("Verify that the correct successful deletion message includes the first name of deleted item");
        Assert.assertTrue("Incorrect successful delete message is displayed",page.mainPage.getSuccessDeleteMessage().contains(page.mainPage.getUniqueFirstName()));


        log.info("Verifying that the correct entry was deleted");
        Assert.assertTrue("Incorrect entry was deleted from the table",page.mainPage.isElementRemovedFromTable());

        log.info("Verify that the table row length has been decreased successfully");
        Assert.assertEquals("The table rows count should be smaller",tableRowLength -1,page.mainPage.getTableRowNumbers());

    }

    @Parameters({"noFirstName","lastName","validMail","company","phone","validBirthDay"})
    @Test(groups = "negativeAddUserTest")
    void addNoFirstNameUser(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }


    @Parameters({"firstName","noLastName","validMail","company","phone","validBirthDay"})
    @Test(groups = "negativeAddUserTest")
    void addNoLastNameUser(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }

    @Parameters({"firstName","lastName","invalidEmail","company","phone","validBirthDay"})
    @Test(groups = "negativeAddUserTest")
    void addInvalidEmailUser(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }


    @Parameters({"firstName","lastName","validMail","company","invalidPhone","validBirthDay"})
    @Test(groups = "negativeAddUserTest")
    void addInvalidPhoneFormatUser(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }


    @Parameters({"firstName","lastName","validMail","company","invalidPhone2","validBirthDay"})
    @Test(groups = "negativeAddUserTest")
    void addInvalidPhoneFormat2User(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }


    @Parameters({"firstName","lastName","validMail","company","phone","invalidBirthDay"})
    @Test(groups = "negativeAddUserTest")
    void addInvalidBirthDayFormatUser(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }


    @Parameters({"firstName","lastName","validMail","company","phone","invalidBirthDay2"})
    @Test(groups = "negativeAddUserTest")
    void addInvalidBirthDayFormat2User(String firstName, String lastName, String email, String company, String phone, String birthDay){

        log.info("Clicking on the 'New user' button");
        page.mainPage.clickNewUserButton();

        log.info("Adding a new user with:" +
                " firstName: " + firstName
                +" lastName: " + lastName
                +" E-mail: " + email
                +" Company: " + company
                +" Phone: " + phone
                +" BirthDay: " + birthDay
        );
        page.addEmployeeFlow.addUserWithoutSubmittingIt(firstName,lastName,email,company,phone,birthDay);

        Assert.assertFalse("The submit button is enabled when it shouldn't",page.addOrEditEmployeePage.isSubmitButtonEnabled());
    }
}
