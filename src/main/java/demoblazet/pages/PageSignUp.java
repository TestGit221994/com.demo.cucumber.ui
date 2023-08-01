package demoblazet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSignUp {

    public WebDriver driver;
    public PageSignUp(WebDriver webDriver) {
        this.driver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h5[contains(text(),'Sign up')]")
    private WebElement lblSignUp;
    public WebElement getLblSignUp(){
        return lblSignUp;
    }


}
