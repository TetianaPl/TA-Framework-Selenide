package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class CreatingEmailAddress {
    public static String createEmailAddress(WebDriver driver) {
        driver.get("https://temp-mail.org/en/");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement copyButton = driver.findElement(By.xpath("//button[@class = 'btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));

        wait.until(ExpectedConditions.elementToBeClickable(copyButton)).click();
        String emailAddress;
        try {
            emailAddress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            throw new RuntimeException(e);
        }
        return emailAddress;
    }
}
