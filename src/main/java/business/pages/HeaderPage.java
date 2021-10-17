package business.pages;

import core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePageObject {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    private By logoutButton = By.xpath("//span[contains(text(),\"Logout\")]/..");
    private By logoutButtonText = By.xpath("//span[contains(text(),\"Logout\")]");
    private By pageHeader = By.xpath("//h1");
    private By mattToolbar = By.xpath("//mat-toolbar");


    /* Get header text */
    public String getHeaderText(){
        return getText(pageHeader);
    }

    /* Click on the logout button */
    public void clickLogoutButton(){
        click(logoutButton);
    }

    /* Get Hex color of h1 */
    public String getH1color(){
        return getCSSColorValueOfElement(pageHeader,"color");
    }

    /* Get Hex color of h1 */
    public String getLogoutTextColor(){
        return getCSSColorValueOfElement(logoutButtonText,"color");
    }

    /* Get Hex color of h1 */
    public String getLogoutButtonBackgroundColor(){
        return getCSSColorValueOfElement(logoutButton,"background-color");
    }

    /* Get Hex color of h1 */
    public String getMattToolbarBackgroundColor(){
        return getCSSColorValueOfElement(mattToolbar,"background-color");
    }

}
