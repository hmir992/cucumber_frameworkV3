package definitions;

import java.util.concurrent.TimeUnit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;
    public static String URL = "http://localhost:3000";

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        // Open the website
        try {
            driver.get(URL);
        } catch (Exception e) {
            System.err.println("Failed to load URL: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Uncomment this if you want to capture screenshots on failure
        /*
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (WebDriverException e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
        */
        driver.quit();
    }
}