package com.nine.test.app;

import com.nine.test.utils.App;
import com.nine.test.utils.CommonUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class base {
    protected static WebDriver driver;
    final static Logger logger = LogManager.getLogger(base.class);

    @BeforeClass
    public void setup() {
        logger.info("Starting Testcase " + this.getClass().getName());
        driver = DriverManager.getDriver(App.getProperty("browser.name"));
        driver.manage().window().maximize();
        driver.get(App.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(CommonUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void finish() throws IOException {
        logger.info("Finishing Testcase" + this.getClass().getName());
        driver.quit();
    }

    public  void getScreenShot(WebDriver driver) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/test-output/TestScreenshot" +this.getClass().getName() + dateName + ".png";
        File DestFile = new File(destination);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
