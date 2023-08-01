package demoblazet.pages;

import demoblazet.utils.misc.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageGoogleSearch {


    public WebDriver driver;
    public PageGoogleSearch(WebDriver webDriver) {
        this.driver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    private WebElement txtSearch;
    public WebElement getTxtSearch(){
        return txtSearch;
    }

    public List<WebElement> getAllLinks(){
        WaitUtils.pause(5000);
        return driver.findElements(By.tagName("cite"));
    }


























}
