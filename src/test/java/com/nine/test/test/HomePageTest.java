package com.nine.test.test;

import com.nine.test.app.base;
import com.nine.test.pages.HomePage;
import com.nine.test.utils.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.nine.test.expectedValue.ExpectedValues.expectedTitle;
import static com.nine.test.expectedValue.ExpectedValues.expectedUrl;

public class HomePageTest extends base {
    private final static Logger logger = LogManager.getLogger(HomePageTest.class);
    HomePage homepage;

    @Test
    public void launchHomePageTest() throws IOException {
        logger.info("Starting Testcase " + this.getClass().getName());
        try {
            homepage=new HomePage(driver);
            Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
            Assert.assertEquals(driver.getTitle(),expectedTitle);
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
