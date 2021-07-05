package com.nine.test.pages;

import com.nine.test.utils.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.nine.test.utils.CommonUtils.isElementPresent;
import static com.nine.test.utils.CommonUtils.waitForPresenceOfElementLocated;

public class PolicyPage {
    private WebDriver driver;
    By subscriptionPrompt=By.xpath("//div[@data-testid='SubscriptionPrompt-false']");

    public PolicyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToUrl(){
        driver.navigate().to(App.getProperty("policy.url"));
    }

    public Boolean isSubscriptionPromptDisappeared(){
        waitForPresenceOfElementLocated(subscriptionPrompt,driver);
        return isElementPresent(subscriptionPrompt,driver);
    }
}
