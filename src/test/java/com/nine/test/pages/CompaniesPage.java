package com.nine.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.nine.test.utils.CommonUtils.waitForElementToBeClickable;

public class CompaniesPage {
    private WebDriver driver;
    String text;

    @FindBy(how= How.LINK_TEXT, using="Companies")
    private WebElement companiesLink;

    @FindBy(how= How.LINK_TEXT, using="Financial Services")
    private WebElement financialServicesLink;

    @FindBy(how= How.CSS, using="div[data-testid='StoryTileBase'] h3:nth-of-type(1) a")
    private WebElement storyTileBase;

    @FindBy(how= How.XPATH, using="//h1")
    private WebElement topic;

    public CompaniesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void shareNewsInFacebook(){
        waitForElementToBeClickable(companiesLink,driver);
        companiesLink.click();
        waitForElementToBeClickable(financialServicesLink,driver);
        financialServicesLink.click();
        waitForElementToBeClickable(storyTileBase,driver);
         text=storyTileBase.getText();
        storyTileBase.click();
    }
    public String getTopic(){
       return topic.getText();
    }
    public String getStoryTile(){
        return text;
    }
}
