package com.nine.test.test;

import com.nine.test.app.base;
import com.nine.test.pages.CompaniesPage;
import com.nine.test.pages.PolicyPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompaniesPageTest extends base {
    private final static Logger logger = LogManager.getLogger(CompaniesPageTest.class);

    @Test
    public void verifyNewsTitle() throws IOException {
        logger.info("Starting Testcase " + this.getClass().getName());
        try {
            CompaniesPage companiesPage =new CompaniesPage (driver);
            companiesPage.shareNewsInFacebook();
            String expected=companiesPage.getStoryTile();
            String actual=companiesPage.getTopic();
            Assert.assertEquals(expected,actual);

        } catch (Exception e) {
            e.printStackTrace();
            getScreenShot(driver);
            logger.error("Testcase failed!" +  e);
            driver.quit();
            setup();
            Assert.fail("Testcase failed!");
        }
    }
}
