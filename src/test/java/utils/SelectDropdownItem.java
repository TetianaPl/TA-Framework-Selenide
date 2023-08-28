package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.HighlightElement.highlightElement;

public class SelectDropdownItem {
    public static void selectItem(WebDriver driver, String item) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//md-option//div[contains(text(), '" + item + "')]"));
        highlightElement(driver, element);
        jsExec.executeScript("arguments[0].click();", element);
    }
}
