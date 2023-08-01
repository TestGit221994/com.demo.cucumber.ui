package demoblazet.utils.misc;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClearCacheUtils {
    private static final Logger logger = LoggerFactory.getLogger(ClearCacheUtils.class);

    public static void clearBrowserCache(WebDriver driver) {


        String browserName = PropertyUtils.getProperty("browser.type");

        switch (browserName) {
            case "chrome":
                driver.get("chrome://settings/clearBrowserData");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Actions actions = new Actions(driver);
                for (int i = 0; i < 7; i++) {
                    actions.sendKeys(Keys.TAB).build().perform();
                }
                actions.sendKeys(Keys.ENTER).build().perform();
                break;
            case "firefox":
                driver.get("about:preferences#privacy");
                driver.findElement(By.id("clearSiteDataButton")).click();
                driver.switchTo().alert().accept();
                break;
            case "edge":
                driver.get("edge://settings/clearBrowserData");
                driver.findElement(By.id("clear-now")).sendKeys(Keys.ENTER);
                break;
        }
    }

    public static WebElement expandRootElement(WebElement element, WebDriver driver) {
        return (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", element);
    }
}