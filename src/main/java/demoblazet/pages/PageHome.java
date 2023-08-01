package demoblazet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHome {

    public WebDriver driver;
    public PageHome(WebDriver webDriver) {
        this.driver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "signin2")
    private WebElement btnSigUp;
    public WebElement getBtnSigUp(){
        return btnSigUp;
    }

    @FindBy(id = "login2")
    private WebElement btnLogIn;
    public WebElement getBtnLogIn(){
        return btnLogIn;
    }

    @FindBy(id = "nameofuser")
    private WebElement lblWelcome;
    public WebElement getLblWelcome(){
        return lblWelcome;
    }






}
