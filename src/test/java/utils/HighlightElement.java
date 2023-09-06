package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HighlightElement {
    public static void highlightElement(SelenideElement element) {
        String bg = element.getCssValue("backgroundColor");

        Selenide.executeJavaScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Selenide.executeJavaScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }
}
