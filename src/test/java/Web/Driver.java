package Web;

import Helpers.Misc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;
@Test
    public static void openUrl(String url) {

        driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.facebook.com/");

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitWebPages() {
        driver.quit();
    }

    }







