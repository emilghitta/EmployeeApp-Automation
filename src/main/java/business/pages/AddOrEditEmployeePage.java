package business.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOrEditEmployeePage extends HeaderPage {
    public AddOrEditEmployeePage(WebDriver driver) {
        super(driver);
    }

    /* *** Locators *** */

    /* Button Locators */
    private By backButton = By.xpath("//app-employee-form/button");
    private By submitButton = By.xpath("//button[@class='mat-raised-button mat-accent']");

    /* First Name input field related Locators */
    private By firstNameField = By.xpath("//input[@name='firstName']");
    private By firstNameLabel = By.xpath("//label[contains(text(),\"first name\")]");

    /* Last Name input field related Locators */
    private By lastNameField = By.xpath("//input[@name='lastName']");
    private By lastNameLabel = By.xpath("//label[contains(text(),\'last name\')]");

    /* E-mail input field related Locators */
    private By emailField = By.xpath("//input[@name='email']");
    private By emailFieldLabel = By.xpath("//label[contains(text(),\"email\")]");

    /* Company input field related Locators */
    private By companyField = By.xpath("//input[@name='company']");

    /* Phone input field related Locators */
    private By phoneField = By.xpath("//input[@name='phone']");
    private By phoneFieldLabel = By.xpath("//label[contains(text(),\"phone\")]");

    /* Date input field related Locators */
    private By dateInputField = By.xpath("//input[@name='birthday']");
    private By dateInputButton = By.xpath("//mat-datepicker-toggle/button");
    private By dateInputLabel = By.xpath("//label[contains(text(),\"Birth day\")]");

    /*  Checkbox input field related Locators */
    private By checkbox = By.xpath("//input[@type='checkbox']/..");
    private By checkboxText = By.xpath("//span[@class='mat-checkbox-label']");

    /* *** Methods *** */

    /* Get page URL */
    public String getPageUrl(){
        return getCurrentUrl();
    }

    /* Fill first name input field  with text */
    public void fillFirstName(String firstName){
        fill(firstNameField,firstName);
    }
    /* Fill last name input field  with text */
    public void fillLastName(String lastName){
        fill(lastNameField,lastName);
    }
    /* Fill e-mail input field  with text */
    public void fillEmail(String email){
        fill(emailField,email);
    }
    /* Fill company input field with text */
    public void fillCompany(String companyName){
        fill(companyField,companyName);
    }
    /* Fill phone input field with text */
    public void fillPhone(String phoneNumber){
        fill(phoneField,phoneNumber);
    }
    /* Fill birth day input field with text */
    public void fillBirthDay(String birthDay){
        fill(dateInputField,birthDay);
    }
    /* Click the checkbox */
    public void clickCheckbox(){
        click(checkbox);
    }
    /* Get checkbox text */
    public String getCheckboxText(){
        return getText(checkboxText);
    }

    /* Click back button */
    public void clickBackButton(){
        click(backButton);
    }

    /* Click submit button */
    public void clickSubmitButton(){
        click(submitButton);
    }
    /* Check if submit button is enabled */
    public boolean isSubmitButtonEnabled(){
        return isElementEnabled(submitButton);
    }
    /* Removing data from First name Field*/
    public void clearFirstNameField(){
        clearElement(firstNameField);
    }
    /* Removing data from Last name Field*/
    public void clearLastNameField(){
        clearElement(lastNameField);
    }

    /* Return color value of first name field */
    public String getFirstNameCSSColorValue(){
        return getCSSColorValueOfElement(firstNameLabel,"color");
    }
    /* Return color value of last name field */
    public String getLastNameCSSColorValue(){
        return getCSSColorValueOfElement(lastNameLabel,"color");
    }
    /* Return color value of e-mail field */
    public String getEmailCSSColorValue(){
        return getCSSColorValueOfElement(emailFieldLabel,"color");
    }
    /* Return color value of phone field */
    public String getPhoneCSSColorValue(){
        return getCSSColorValueOfElement(phoneFieldLabel,"color");
    }
    /* Return color value of birth day field */
    public String getBirthDayCSSColorValue(){
        return getCSSColorValueOfElement(dateInputLabel,"color");
    }
    /* Click the e-amil field */
    public void clickEmailField(){
        click(emailField);
    }

}
