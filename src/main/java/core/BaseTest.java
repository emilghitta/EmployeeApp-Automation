package core;

import business.pages.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import testdata.DriverTypes;
import java.lang.reflect.Method;



public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    protected Page page;
    protected WebDriverWait wait;
    private static ITestContext context;

    @Parameters({"testPage","validEmail","validPassword"})
    @BeforeMethod(alwaysRun = true) //Is alwaysRun due to execution form XML file. We force the Before Method trigger. Otherwise this method will be skipped.
    public void setUp(String testPage,@Optional String validEmail, @Optional String validPassword,ITestContext ctx, Method method) {

        /* We are retrieving the current xml test name so we can use it for our Log4J output */
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(log);
        driver = factory.createDriver(DriverTypes.CHROME);
        page = new Page(driver);
        driver.get(testPage);

        /* We are setting the current test context and driver for further usage in our test listeners */
        context = setContext(ctx,driver);

        log.info("Opening: " + testPage);
        driver.manage().window().maximize();

        if(validEmail != null && validPassword != null){
            log.info("Performing authentication flow with valid credentials as a test precondition");
            page.loginFlow.authenticate(validEmail,validPassword);

            /* Force authentication when error message was displayed event though valid credentials were sent.
            *  Also using a counter so we do fail this if to many attempts are made.
            */
            int counter = 0;
            while(page.loginPage.isErrorMessageDisplayed() && counter <= 3){
                driver.navigate().refresh();
                page.loginFlow.authenticate(validEmail,validPassword);
                counter++;
            }
        }
        wait = new WebDriverWait(driver, 5);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        log.info("Test finished.Closing the browser");
        driver.quit();
    }

    /* Setting current test context for further usage in our test listeners */
    public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("driver", driver);

        return iTestContext;
    }
}
