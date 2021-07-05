package com.nine.test.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.TestException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class CommonUtils {
    public static long IMPLICIT_WAIT=120;
    public static WebDriverWait wait;
    private static int timeout = 100;

    public static void switchWindow(WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String handle: windows){
            driver.switchTo().window(handle);
        }
    }

    public static void waitForElementToBeClickable(WebElement element,WebDriver driver) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new TestException("The following element is not clickable: " + element);
        }
    }

    public static void scrollIntoTheElementAndClick(WebElement element,WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitForElementToClick(element,driver);
        js.executeScript("arguments[0].scrollIntoView()", element);
        js.executeScript("arguments[0].click();", element);
    }
    public static void clickAnElement(WebElement element,WebDriver driver) {
        waitForElementToClick(element,driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void waitForElementToClick(WebElement element, WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

    }
    public static void scrollPageDown(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
     }
    public static void waitForPresenceOfElementLocated(By by,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        // presenceOfElementLocated condition
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean isElementPresent(By by,WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    }
