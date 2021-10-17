package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class Listeners extends TestUtilities implements ITestListener {
    /* We are making extent test to be thread safe because we are running tests in parallel */

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    ExtentReports extent = ExtentReporter.generateExtentReport("src/test/java/resources/Reports/TestReport"+ dateFormat.format(date) +".html","src/test/java/resources/Reports/extent-config.xml");
    ExtentTest test;

    public Listeners() throws IOException {
    }

    @Override
    public void onTestStart(ITestResult result) {
        /* We are creating the test having the test method name
         * We are saving the extent test for each thread.
         */

         test = extent.createTest(result.getMethod().getMethodName());
         extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        /* We are marking it as a test PASS in our report.
         * For the current thread's extentTest */
        extentTest.get().log(Status.PASS,"Successfully test");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        /* We are printing the stacktrace on failure */
        extentTest.get().fail(result.getThrowable());

        /* We are getting the current thread's driver and using it further to generate screenshots and attach it to specific thread test. */
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String screenshot;
        try {
            screenshot = getScreenshotPath(result.getMethod().getMethodName() + result.getInstance().toString(), driver);
            extentTest.get().addScreenCaptureFromPath(screenshot);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        /* We use extent.flush() to generate the report.
         * No need to use a key thread because the on finish happens after all tests have finished their execution.
         */
        extent.flush();
    }
}
