package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static utils.HighlightElement.highlightElement;

public class CloudGooglePage {
    protected static Logger logger = LogManager.getRootLogger();

    public void enterSearchQuery(String searchQuery) {
        SelenideElement searchField = $(By.xpath("//input[@name = 'q']"));
        highlightElement(searchField);
        actions().moveToElement(searchField).click().build().perform();
        searchField.sendKeys(searchQuery);
        actions().keyDown(Keys.ENTER).click().build().perform();
        logger.info("Search  by " + searchQuery + " started.");
    }

    public void findInSearchResults(String text) {
        SelenideElement searchResult = $(By.xpath("//div[@class='gsc-thumbnail-inside']//a[@class='gs-title']/b[text()= '" + text + "']"));
        logger.info("Followed the link found: " + searchResult.getText());
        highlightElement(searchResult);
        Selenide.executeJavaScript("arguments[0].click();", searchResult);
    }
}
