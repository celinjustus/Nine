package com.nine.test.test;

import com.nine.test.app.base;
import com.nine.test.pages.PolicyPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import static com.nine.test.utils.CommonUtils.scrollPageDown;

public class PolicyPageTest extends base {
    private final static Logger logger = LogManager.getLogger(PolicyPageTest.class);

    @Test
    public void verifyPopup() throws IOException {
        logger.info("Starting Testcase " + this.getClass().getName());
        try {
            PolicyPage PolicyPage =new PolicyPage (driver);
            PolicyPage.navigateToUrl();
            getScreenShot(driver);
            scrollPageDown( driver);
            Boolean subscriptionPopUpStatus=PolicyPage.isSubscriptionPromptDisappeared();
            Assert.assertTrue(subscriptionPopUpStatus);
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
