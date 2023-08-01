package demoblazet.stepDefinition;

import demoblazet.Steps.DemoBlazeSteps;
import demoblazet.utils.misc.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static demoblazet.stepDefinition.BaseClass.navigateToLoginPage;

public class DemoBlazeStepDefinition {

    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps();

    @Given("initialise browser")
    public void initialiseBrowser() {
        navigateToLoginPage();
    }

    @When("User enter {string} in google search field and hit enter button")
    public void userEnterDemo_blazeInGoogleSearchFieldAndHitEnterButton(String searchValue) {
          demoBlazeSteps.enterValueIntoSearchFiled(searchValue);

    }

    @When("User collect all the sites-Links on google search result page")
    public void userCollectAllTheSitesLinksOnGoogleSearchResultPage() throws InterruptedException {
        demoBlazeSteps.userCollectSitesLinks();
    }

    @Then("Validate BlazeLinks should be available from list of sites-Links")
    public void validateBlazeLinksShouldBeAvailableFromListOfSitesLinks() {
        demoBlazeSteps.validateBlazeLinksShouldBeAvailableFromListOfSitesLinks();
    }

    @When("User click on first link from the listed sites")
    public void userClickOnFirstLinkFromTheListedSites() {
        demoBlazeSteps.clickOnFirstLinkFromTheListedSites();
        WaitUtils.pause(2000);
    }

    @Then("Validate user should be navigate on home page of demo blaze site")
    public void validateUserShouldBeNavigateOnHomePageOfDemoBlazeSite() {
        demoBlazeSteps.userShouldBeNavigateOnHomePageOfDemoBlazeSite();
    }

    @And("User click on SignUp button on home page")
    public void userClickOnSignUpButtonOnHomePage() {
        demoBlazeSteps.clickOnSignUpButtonOnHomePage();
    }

    @Then("Validate user should be navigate on SignUp Page")
    public void validateUserShouldBeNavigateOnSignUpPage() {
        demoBlazeSteps.ValidateUserShouldBeNavigateOnSignUpPage();
    }

    @And("User click on LogIn button on home page")
    public void userClickOnLogInButtonOnHomePage() {
        demoBlazeSteps.clickOnLogInButtonOnHomePage();
        WaitUtils.pause(3000);
    }

    @And("User enter username {string}")
    public void userEnterUsername(String username) {
        demoBlazeSteps.enterUsername(username);
    }

    @And("User enter password {string}")
    public void userEnterPassword(String password) {
        demoBlazeSteps.enterPassword(password);
    }

    @And("User click on LogIn button on login page")
    public void userClickOnLogInButtonOnLoginPage() {
        demoBlazeSteps.clickOnLogInButtonOnLoginPage();
        WaitUtils.pause(3000);
    }

    @Then("Validate user should get welcome message after success of login")
    public void validateUserShouldGetWelcomeMessageAfterSuccessOfLogin() {
        demoBlazeSteps.ValidateUserShouldGetWelcomeMessageAfterSuccessOfLogin();
    }

}
