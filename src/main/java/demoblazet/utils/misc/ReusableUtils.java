package demoblazet.utils.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

import static org.slf4j.LoggerFactory.getLogger;

public class ReusableUtils {
    private static final Logger logger = getLogger(ReusableUtils.class);
    public static WebDriverWait wait;

    public ReusableUtils(WebDriver driver){
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    //Click Method
    public static void click(By by) { waitVisibility(by).click();
        logger.info("The " + by + " is clicked");
    }

    public static void click(WebElement Elementtobeclicked) {
        logger.info("The " + Elementtobeclicked.getText() + " is clicked");
        Elementtobeclicked.click();
    }

    //Write Text
    public static void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
        logger.info("The " + text +" is entered");
    }

    public static void writeText(WebElement webElement, String text) {
        waitVisibility(webElement).sendKeys(text);
        logger.info("The " + text +" is entered");
    }

    //Read Text
    public static String readText(By by) {
        logger.info("The Text Retrived as " + waitVisibility(by).getText());
        return waitVisibility(by).getText();

    }

    public static String readText(WebElement webElement) {
        logger.info("The Text Retrived as " + waitVisibility(webElement).getText());
        return waitVisibility(webElement).getText();

    }

    public static boolean elementDisplayed(By by) {
        logger.info("The Element " + by + " is displayed");
        return waitVisibility(by).isDisplayed();

    }

    public static boolean elementDisplayed(WebElement webelement) {
        logger.info("The Element " + webelement + " is displayed");
        return waitVisibility(webelement).isDisplayed();

    }


    public static boolean elementEnabled(By by) {
        logger.info("The Element " + by + " is enabled");
        return waitVisibility(by).isEnabled();
    }

    public static boolean elementEnabled(WebElement webElement) {
        logger.info("The Element " + webElement + " is enabled");
        return waitVisibility(webElement).isEnabled();
    }

    //Wait
    public static WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitVisibility(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void selectValueFromDropDown(WebElement element,String DropDownvalue){
        Select sc=new Select(element);
        sc.selectByVisibleText(DropDownvalue);
        logger.info("The DropDown Value " + DropDownvalue + " is Selected");
    }

    public static void clearAndEnterText(WebElement webElement,String text){
        waitVisibility(webElement).click();
        webElement.sendKeys(Keys.CONTROL+"A");
        webElement.sendKeys(Keys.BACK_SPACE);
        webElement.sendKeys(text);
        logger.info("The " + text +" is entered");
    }
}