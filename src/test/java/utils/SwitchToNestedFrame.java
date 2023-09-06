package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class SwitchToNestedFrame {
    public static void switchToNestedFrame() {
        SelenideElement iframe = $("article#cloud-site>devsite-iframe>iframe");
        switchTo().frame(iframe);
//        switchTo().frame(0);
        iframe = $(By.id("myFrame"));
        switchTo().frame(iframe);
    }
}
