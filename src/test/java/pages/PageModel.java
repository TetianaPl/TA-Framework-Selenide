package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageModel {
    protected WebDriver driver;

    public PageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
