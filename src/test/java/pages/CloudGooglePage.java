package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CloudGooglePage extends PageModel{

    @FindBy(xpath = "//input[@name = 'q']")
    private static WebElement searchField;

    @FindBy(xpath = "//div[@class='gsc-results gsc-webResult']")
    private static WebElement searchResults;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
    }

    public void clickSearch(){
        Actions actions = new Actions(driver);
        actions.moveToElement(searchField).click().build().perform();
    }

    public void enterSearchQuery(String searchQuery){
        searchField.sendKeys(searchQuery);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).click().build().perform();
    }

    public void findInSearchResults(String text){
        searchResults.findElement(By.xpath("//div[@class='gsc-thumbnail-inside']//a[@class='gs-title']/b[text()= '" + text + "']")).click();
    }

}
