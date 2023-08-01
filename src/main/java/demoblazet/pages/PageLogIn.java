package demoblazet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogIn {

    public WebDriver driver;
    public PageLogIn(WebDriver webDriver) {
        this.driver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h5[contains(text(),'Log in')]")
    private WebElement lblLogIN;
    public WebElement getLblLogIN(){
        return lblLogIN;
    }

    @FindBy(id = "loginusername")
    private WebElement txtUsername;
    public WebElement getTxtUsername(){
        return txtUsername;
    }


    @FindBy(id = "loginpassword")
    private WebElement txtPassword;
    public WebElement getTxtPassword(){
        return txtPassword;
    }

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement btnLogIn;
    public WebElement getBtnLogIn(){
        return btnLogIn;
    }




}
