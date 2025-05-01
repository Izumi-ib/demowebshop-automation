package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;


public class AllureUtils {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void log(Logger logger, String message) {
        logger.info(message);
        attachLog(message);
    }

    public static void log(Logger logger, String format, Object... args) {
        String message = String.format(format, args);
        logger.info(message);
        attachLog(message);
    }

    private static void attachLog(String message) {
        try {
            Allure.getLifecycle().addAttachment("Log", "text/plain", ".txt", message.getBytes());
        } catch (Exception e) {
            System.err.println("Allure attachment failed: " + e.getMessage());
        }
    }
}
