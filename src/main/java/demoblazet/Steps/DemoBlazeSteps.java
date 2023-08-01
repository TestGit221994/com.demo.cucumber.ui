package demoblazet.Steps;

import demoblazet.pages.PageGoogleSearch;
import demoblazet.pages.PageHome;
import demoblazet.pages.PageLogIn;
import demoblazet.pages.PageSignUp;
import demoblazet.stepDefinition.BaseClass;
import demoblazet.utils.misc.WaitUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

import static demoblazet.utils.misc.PropertyUtils.getProperty;

public class DemoBlazeSteps {


    PageGoogleSearch pageGoogleSearch;
    PageHome pageHome;
    PageLogIn pageLogIn;
    PageSignUp pageSignUp;
    public static List<WebElement> listOfAllLinkOnGoogleSearchPage;

    public void enterValueIntoSearchFiled(String searchValue){
        pageGoogleSearch = new PageGoogleSearch(BaseClass.getWebDriver());
        pageGoogleSearch.getTxtSearch().sendKeys(searchValue);
        pageGoogleSearch.getTxtSearch().sendKeys(Keys.ENTER);
    }

    public void userCollectSitesLinks(){
        pageGoogleSearch = new PageGoogleSearch(BaseClass.getWebDriver());
        listOfAllLinkOnGoogleSearchPage = pageGoogleSearch.getAllLinks();
    }

    public void validateBlazeLinksShouldBeAvailableFromListOfSitesLinks() {

        List<String> expectedLinksOnGoogleSearchPage = new LinkedList<>();
        expectedLinksOnGoogleSearchPage.add(getProperty("blaze.user.url1").trim());
        expectedLinksOnGoogleSearchPage.add(getProperty("blaze.user.url2").trim());

        Boolean linksAvailabilityStatus = false;

        for(WebElement link : listOfAllLinkOnGoogleSearchPage){
            if(expectedLinksOnGoogleSearchPage.contains(link.getText().trim())){
                linksAvailabilityStatus = true;
            }
        }
        Allure.step(" linksAvailabilityStatus "+linksAvailabilityStatus);
        Assert.assertTrue(linksAvailabilityStatus,"verifyBlazeLinksOnGoogleSearchPage");

    }

    public void clickOnFirstLinkFromTheListedSites(){
        pageGoogleSearch = new PageGoogleSearch(BaseClass.getWebDriver());
        pageGoogleSearch.getAllLinks().get(0).click();
    }

    public void userShouldBeNavigateOnHomePageOfDemoBlazeSite(){

        Allure.step("Actual : " + BaseClass.getWebDriver().getCurrentUrl().trim() + "   Expected : " + getProperty("blaze.user.url1")+"/".trim());
        Assert.assertEquals(BaseClass.getWebDriver().getCurrentUrl().trim(),getProperty("blaze.user.url1")+"/".trim(),"verifyUserShouldBeNavigateToBlazeHomePage");

    }

    public void clickOnSignUpButtonOnHomePage(){
         pageHome = new PageHome(BaseClass.getWebDriver());
         pageHome.getBtnSigUp().click();
    }

    public void ValidateUserShouldBeNavigateOnSignUpPage(){
        WaitUtils.pause(3000);
        pageSignUp = new PageSignUp(BaseClass.getWebDriver());
        Allure.step("Actual : "+pageSignUp.getLblSignUp().isDisplayed() + "   Expected : " +true);
        Assert.assertTrue(pageSignUp.getLblSignUp().isDisplayed(),"verifyUserShouldBeNavigateToSignUpPage");
    }

    public void clickOnLogInButtonOnHomePage(){
        pageHome = new PageHome(BaseClass.getWebDriver());
        pageHome.getBtnLogIn().click();
    }

    public void enterUsername(String username){
        pageLogIn = new PageLogIn(BaseClass.getWebDriver());
        WaitUtils.pause(3000);

        pageLogIn.getTxtUsername().sendKeys(username.trim());
    }

    public void enterPassword(String password){
        pageLogIn = new PageLogIn(BaseClass.getWebDriver());
        WaitUtils.pause(3000);

        pageLogIn.getTxtPassword().sendKeys(password.trim());
    }

    public void clickOnLogInButtonOnLoginPage(){
        pageLogIn = new PageLogIn(BaseClass.getWebDriver());
        pageLogIn.getBtnLogIn().click();
    }

    public void ValidateUserShouldGetWelcomeMessageAfterSuccessOfLogin(){
        WaitUtils.pause(5000);

        pageHome = new PageHome(BaseClass.getWebDriver());

        Allure.step(" Actual : " +pageHome.getLblWelcome().getText().trim() + "   Expected : "+"Welcome "+getProperty("blaze.username").trim());
        Assert.assertEquals(pageHome.getLblWelcome().getText().trim(),"Welcome "+getProperty("blaze.username").trim(),"VerifyUserShouldGetWelcomeMessageAfterLogin");

    }




}
