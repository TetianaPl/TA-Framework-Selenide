package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.HighlightElement.highlightElement;

public class CreatingEmailAddress {
    public static String createEmailAddress() {
        open("https://temp-mail.org/en/");

        SelenideElement copyButton = $(By.xpath("//button[@class = 'btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));
        copyButton.shouldBe(Condition.enabled).click();
        highlightElement(copyButton);

        String emailAddress;
        try {
            emailAddress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException(e);
        }
        return emailAddress;
    }
}
