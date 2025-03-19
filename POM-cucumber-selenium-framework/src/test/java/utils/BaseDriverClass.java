package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriverClass {
	private static WebDriver driver;
    private static WebDriverWait wait;

    public BaseDriverClass(WebDriver driver) {
        this.driver = driver;
    }

    public BaseDriverClass() {
    }
}
