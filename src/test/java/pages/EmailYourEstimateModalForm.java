package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static utils.HighlightElement.highlightElement;

public class EmailYourEstimateModalForm {
    protected static Logger logger = LogManager.getRootLogger();

    public void enterEmailAddress(String emailAddress) {
        SelenideElement emailField = $(By.xpath("//input[@ng-model='emailQuote.user.email']"));
        highlightElement(emailField);
        emailField.click();
        emailField.sendKeys(emailAddress);
        logger.info("The email address " + emailAddress + " is filled in the Email field on the 'Email Your Estimate' form.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickSendEmailButton() {
        SelenideElement sendEmailButton = $(By.xpath("//button[contains(text(), 'Send Email')]"));
        highlightElement(sendEmailButton);
        Selenide.executeJavaScript("arguments[0].click();", sendEmailButton);
        logger.info("The 'Email Your Estimate' form submitted.");
    }
}
