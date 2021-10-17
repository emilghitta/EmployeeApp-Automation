package business.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends HeaderPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /* Unique identifier used for xpath parametrization */
    private static String uniqueFirstName ="";

    /* *** Locators *** */

    /* Welcome message locator */
    private By welcomeMessage = By.xpath("//div[@class=\"welcome\"]");

    /* Table data locator (parametrized) */
    private By relevantTableFirstNameCell = By.xpath("//td[contains(text(),'"+uniqueFirstName+"')]");
    private By allTableRows = By.xpath("//tbody/tr");


    /* Button locators */
    private By newUserButton = By.xpath("//app-employee/button");
    private By editButtons = By.xpath("//span[contains(text(),'edit')]/..");
    private By relevantDeleteButton = By.xpath("//td[contains(text(),'"+uniqueFirstName+"')]/following-sibling::td[last()]/button/span[contains(text(),\"del\")]/..");

    /*Confirmation locators */
    private By confirmNoButton = By.xpath("//span[text() ='No']/..");
    private By confirmYesButton = By.xpath("//span[text() ='Yes']/..");
    private By confirmationMessageYesButton = By.xpath("//span[text() = 'Yes']/..");
    private By confirmationMessageNoButton = By.xpath("//span[text() = \"No\"]/..");
    private By confirmationNotification = By.xpath("//p[contains(text(),'Are you sure ?')]/../../../..");
    private By deleteSuccessMessage = By.xpath("//span[contains(text(),\"Delete done\")]");

    /* Set the unique identifier that is going to be used for xpath parametrization */
    public void setUniqueFirstName(String uniqueFirstName) {
        MainPage.uniqueFirstName = uniqueFirstName;

    }

    /* *** Methods *** */

    /* Get the unique indentifier */
    public String getUniqueFirstName() {
        return uniqueFirstName;
    }

    /* Get current url */
    public String getPageUrl(){
        return getCurrentUrl();
    }

    /* Get Welcome message text */
    public String getWelcomeMessage(){
        return getText(welcomeMessage);
    }

    /* Click to add new user button */
    public void clickNewUserButton(){
        click(newUserButton);
    }

    /* Find if certain item is displayed in the table */
    public boolean findUniqueElementInTable(){
        return isElementDisplayed(relevantTableFirstNameCell);
    }

    /* Find if certain item has been successfully removed from the table */
    public boolean isElementRemovedFromTable(){
        return isElementRemovedFromTable(relevantTableFirstNameCell);
    }

    /* Click the delete button */
    public void deleteTableEntry(){
        click(relevantDeleteButton);
    }

    /* Return the number of table rows */
    public int getTableRowNumbers(){
        return getNumberOfTableRows(finElements(allTableRows));
    }

    /* Click the yes delete confirmation button */
    public void clickConfirmationYesButton(){
        click(confirmationMessageYesButton);
    }

    /* Click the no delete confirmation button */
    public void clickConfirmationNoButton(){
        click(confirmationMessageNoButton);
    }

    /* Get the delete success message */
    public String getSuccessDeleteMessage(){
        return getText(deleteSuccessMessage);
    }



}
