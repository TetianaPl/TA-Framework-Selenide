package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static utils.HighlightElement.highlightElement;

public class SelectDropdownItem {
    public static void selectItem(String item) {
        SelenideElement element = $(By.xpath("//md-option//div[contains(text(), '" + item + "')]"));
        highlightElement(element);
        Selenide.executeJavaScript("arguments[0].click();", element);
    }
}
