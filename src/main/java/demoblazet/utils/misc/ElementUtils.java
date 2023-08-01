package demoblazet.utils.misc;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    public static Logger logger = LoggerUtils.getLogger();

    public static void click(WebDriver driver, WebElement webElement,String what){
     try{
         webElement.click();
         logger.info(" click on : " +what);
     }catch (ElementNotInteractableException e){
         Actions builder = new Actions(driver);
         builder.moveToElement(webElement).click().build().perform();
         waitForJStoLoad(driver);
         logger.info(" click on : " +what);
     }
    }

    public static void enter(WebDriver driver, WebElement webElement,String value,String what){
        try{
            webElement.sendKeys(value.trim());
            logger.info(" enter value : " +value + " into : " +what);
        }catch (ElementNotInteractableException e){
            Actions builder = new Actions(driver);
            webElement.sendKeys(value.trim());
            logger.info(" enter value : " +value + " into : " +what);
        }
    }

    public static String getValue(WebDriver driver, WebElement webElement,String what){
        String value;
        try{
            value = webElement.getText().trim();
            logger.info(" get Value from : " +what);
        }catch (ElementNotInteractableException e){
            Actions builder = new Actions(driver);
            value = webElement.getText().trim();
            logger.info(" get Value from : " +what);
        }return value;
    }
















    public static boolean waitForJStoLoad(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<Boolean> jqueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try{
                    return ((Long) javascriptExecutor.executeScript("return jQuery.active") == 0);
                }catch (Exception ae){
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return javascriptExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return (Boolean) wait.until(jqueryLoad) && (Boolean) wait.until(jsLoad);
    }







}
