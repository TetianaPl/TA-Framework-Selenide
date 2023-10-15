package utils;

import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Calendar;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SaveScreenshotRP {
    public static void saveScreenshotRP(String message) {
        File screenCapture = ((TakesScreenshot) getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        ReportPortal.emitLog("RP Logger:>>>>> " + message, "INFO", Calendar.getInstance().getTime(), screenCapture);
    }
}
