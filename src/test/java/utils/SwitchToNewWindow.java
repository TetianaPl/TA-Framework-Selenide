package utils;

import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SwitchToNewWindow {
    public static String openAndSwitchToNewWindow() {
        switchTo().newWindow(WindowType.TAB);
        return getWebDriver().getWindowHandle();
    }
}
