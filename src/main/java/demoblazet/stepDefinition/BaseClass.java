package demoblazet.stepDefinition;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;

import java.io.File;

import static demoblazet.utils.misc.PropertyUtils.getProperty;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseClass {
    private static final Logger logger = getLogger(BaseClass.class);
    static private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static ThreadLocal<String> browserName=new ThreadLocal<>();

    public synchronized static void setBrowserName(String bName){
        browserName.set(bName);

    }

    public synchronized static String getBName(){
        return browserName.get();
    }

    public static WebDriver getWebDriver() {
        return driver.get();
    }


    public synchronized static String getBrowserName(){
        return browserName.get();
    }



    public synchronized static void initializeBrowser() {

        switch ("chrome") {
            case "edge":
                EdgeOptions eo = new EdgeOptions();
                String path=System.getProperty("user.dir") + File.separator + "src/test/resources/drivers/msedgedriver.exe";
                System.setProperty("webdriver.edge.driver", path.trim());
                driver.set(new EdgeDriver());
                driver.get().manage().window().maximize();
                break;
            default:
                System.out.println("I am in chrome");
                ChromeOptions co = new ChromeOptions();
                //String path1=System.getProperty("user.dir") + File.separator + "src/test/resources/drivers/chromedriver.exe";
               // System.setProperty("webdriver.chrome.driver", path1.trim());
                driver.set(WebDriverManager.chromedriver().capabilities(co).create());
                driver.get().manage().window().maximize();

        }
    }

    @Parameters({"browser"})
    public static void navigateToLoginPage() {

        initializeBrowser();
        logger.info("navigating to pbl webapp " + getProperty("blaze.user.url"));
        driver.get().get(getProperty("blaze.user.url"));
    }

   @After(order = 0)
    public void quitDriver() {
        getWebDriver().quit();
    }
}