package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailYourEstimateModalForm extends PageModel{
    @FindBy(xpath = "//input[@id='input_515']")
    private static WebElement emailField;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private static WebElement sendEmailButton;

    public EmailYourEstimateModalForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String emailAddress){
        emailField.click();
        emailField.sendKeys(emailAddress);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickSendEmailButton(){
        sendEmailButton.click();
    }
}
