package utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ReadResult {
    public static double readResult(String source) {
        if (source.equals("email")) {
            Selenide.executeJavaScript("arguments[0].scrollIntoView(false);", $(By.xpath("//h3[text()='Total Estimated Monthly Cost']")));
        }
        String result;
        switch (source) {
            case "calculatorForm":
                result = $(By.xpath("//*[@id='resultBlock']//b[contains(text(), 'Total Estimated Cost:')]")).getText();
                break;
            case "email":
                result = $(By.xpath("//h2[contains(text(), 'Estimated Monthly Cost:')]")).getText();
                break;
            default:
                result = "";
        }
        return Double.parseDouble(result.split(" USD ")[1].
                split(" per")[0].
                replaceAll(",", ""));
    }
}
