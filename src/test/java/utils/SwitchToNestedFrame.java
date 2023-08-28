package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToNestedFrame {
    public static void switchToNestedFrame(WebDriver driver) {
        WebElement iframe = driver.findElement(By.cssSelector("article#cloud-site>devsite-iframe>iframe"));
        driver.switchTo().frame(iframe);
//        driver.switchTo().frame(0);
        iframe = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(iframe);
    }
}
