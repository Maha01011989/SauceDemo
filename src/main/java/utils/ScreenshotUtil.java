package utils;

import constants.Config;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    CommonUtils commonUtils = new CommonUtils();

    public String getScreenshot(String ssName) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        String destination = Config.SCREENSHOTPATH + ssName + commonUtils.getDateFormat() + ".png";
        FileHandler.copy(scrShot.getScreenshotAs(OutputType.FILE), new File(destination));
        return destination;

    }


}
