package business.pages;

import business.flows.AddEmployeeFlow;
import business.flows.LoginFlow;
import org.openqa.selenium.WebDriver;

public class Page {
    public LoginPage loginPage;
    public LoginFlow loginFlow;
    public MainPage mainPage;
    public AddOrEditEmployeePage addOrEditEmployeePage;
    public AddEmployeeFlow addEmployeeFlow;
    public HeaderPage headerPage;

    /* Constructor used to initialize all pages of the application */
    public Page(WebDriver driver){
        loginPage = new LoginPage(driver);
        loginFlow = new LoginFlow(driver);
        mainPage = new MainPage(driver);
        addOrEditEmployeePage = new AddOrEditEmployeePage(driver);
        addEmployeeFlow = new AddEmployeeFlow(driver);
        headerPage = new HeaderPage(driver);
    }

}
