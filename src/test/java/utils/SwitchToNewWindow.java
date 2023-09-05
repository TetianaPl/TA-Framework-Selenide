package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class SwitchToNewWindow {
    public static String openAndSwitchToNewWindow(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB);
        return driver.getWindowHandle();
    }
}
