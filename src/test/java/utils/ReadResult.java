package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadResult {
    public static double readResult(WebDriver driver, String source) {
        String result = switch (source) {
            case "calculatorForm" ->
                    driver.findElement(By.xpath("//*[@id='resultBlock']//b[contains(text(), 'Total Estimated Cost:')]")).getText();
            case "email" -> driver.findElement(By.xpath("//h2[contains(text(), 'Estimated Monthly Cost:')]")).getText();
            default -> "";
        };
        return Double.parseDouble(result.split(" USD ")[1].split(" per")[0].replaceAll(",", ""));
    }
}
