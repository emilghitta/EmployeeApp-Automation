package core;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testdata.DriverTypes;

public class BrowserDriverFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //We are making driver thread safe for parallel execution.
    private Logger log;
    public BrowserDriverFactory(Logger log){
        this.log = log;
    }

    public WebDriver createDriver(DriverTypes browser){
        log.info("Creating Webdriver");

        switch (browser){
            case CHROME:
                    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                    driver.set(new ChromeDriver());
                    break;

            case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver.set(new FirefoxDriver());
                    break;

            default:
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver());
        }

        /* Returning the thread specific driver */
        return driver.get();
    }
}
