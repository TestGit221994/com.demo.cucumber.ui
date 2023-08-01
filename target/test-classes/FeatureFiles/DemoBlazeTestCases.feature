Feature: Validate DemoBlaze Test Cases

  Background:
    Given initialise browser
    When User enter 'demo_blaze' in google search field and hit enter button

  @Smoke1
  Scenario: verify BlazeLinks On Google Search result Page
    When User collect all the sites-Links on google search result page
    Then Validate BlazeLinks should be available from list of sites-Links

  @Smoke1
  Scenario: verify User Should Be Navigate To Blaze Home Page
    When User click on first link from the listed sites
    Then Validate user should be navigate on home page of demo blaze site

  @Smoke1
  Scenario: verify User Should Be Navigate To SignUp Page
    When User click on first link from the listed sites
    And User click on SignUp button on home page
    Then Validate user should be navigate on SignUp Page

  @Smoke1
  Scenario: Verify User Should Get Welcome Message After Login
    When User click on first link from the listed sites
    And User click on LogIn button on home page
    And User enter username 'TestDB'
    And User enter password 'demoblaze@123'
    And User click on LogIn button on login page
    Then Validate user should get welcome message after success of login

