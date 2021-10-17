package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class BasePageObject {
    WebDriver driver;

    public BasePageObject(WebDriver driver){
        this.driver = driver;
    }

        /* Return page URL */
    protected String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

        /* Find and return a WebElement */
    protected WebElement findElement(By locator){
            waitForVisibility(locator,5);
            return driver.findElement(locator);
    }

        /* Find and return multiple WebElements */
    protected List<WebElement> finElements(By locator){
        waitForVisibility(locator,5);
        return driver.findElements(locator);
    }

        /* Click on a element */
    protected void click(By locator){
        waitForVisibility(locator,5);
        findElement(locator).click();
    }

    /* Clear element input field */
    protected void clearElement(By locator){
        waitForVisibility(locator,5);
        findElement(locator).clear();
    }

        /* Send keys to element */
    protected void fill(By locator, String input){
        waitForVisibility(locator,8);
        findElement(locator).sendKeys(input);
    }

        /* Get text from element */
    protected String getText(By locator){
        waitForVisibility(locator,8);
        return findElement(locator).getText();
    }

    /* Get CSS value from element as a HEX value */
    protected String getCSSColorValueOfElement(By locator, String attribute){
        waitForVisibility(locator,5);
        return Color.fromString(findElement(locator).getCssValue(attribute)).asHex();
    }

    /* Verify if element is displayed */
    protected boolean isElementDisplayed(By locator){
        try{
            return findElement(locator).isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }

    }

    /* Verify if an element is enabled*/
    protected boolean isElementEnabled(By locator){
        waitForElementToBeEnabled(locator,5);
        return findElement(locator).isEnabled();
    }

    protected boolean isElementRemovedFromTable(By locator){
        waitForInvisibility(locator,5);
        return finElements(locator).size() <= 0;
    }

    /* Get number of items present inside the WebElement list */
    protected int getNumberOfTableRows(List<WebElement> Elements){
        return Elements.size();
    }

    /* Utility waits used only in BasePageObject */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(condition);
    }

    private void waitForVisibility(By locator, Integer time){
        try{
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),time);
        }catch (StaleElementReferenceException | TimeoutException e){
            System.out.println(e);
        }
    }

    private void waitForInvisibility(By locator, Integer time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private void waitForElementToBeEnabled(By locator, Integer time){
        try{
            waitFor(ExpectedConditions.elementToBeClickable(locator),time);
        }catch (TimeoutException e){
            System.out.println(e);
        }
    }
}
