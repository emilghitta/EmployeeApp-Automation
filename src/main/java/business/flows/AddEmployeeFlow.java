package business.flows;

import business.pages.AddOrEditEmployeePage;
import org.openqa.selenium.WebDriver;

public class AddEmployeeFlow extends AddOrEditEmployeePage {
    public AddEmployeeFlow(WebDriver driver) {
        super(driver);
    }

    /* Add user flow with submission */
    public void addUser(String firstName, String lastName, String email, String company, String phone, String birthDay){
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillCompany(company);
        fillPhone(phone);
        fillBirthDay(birthDay);
        clickCheckbox();
        clickSubmitButton();
    }

    /* Add user flow without submission.
    *  Can be used in negative flows to check the submit button enable/disabled status */
    public void addUserWithoutSubmittingIt(String firstName, String lastName, String email, String company, String phone, String birthDay){
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillCompany(company);
        fillPhone(phone);
        fillBirthDay(birthDay);
        clickCheckbox();
    }
}
