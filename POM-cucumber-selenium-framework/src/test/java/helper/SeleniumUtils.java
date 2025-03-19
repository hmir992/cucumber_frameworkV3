package helper;

import junit.framework.Assert;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

@Log4j2
public class SeleniumUtils {

	private WebDriver driver;

	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static void WaitForElement(WebDriver driver, WebElement element, int timeOutInSeconds) {
		log.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible..");
	}

	public static void scrollUp(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public static void scrollDown(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public static void selectAndScroll(WebDriver driver, WebElement dropdownXPath, WebElement optionXPath) {
		// Find the dropdown and option elements

		// Click the dropdown to open it
		//dropdownXPath.click();

		// Use JavaScript to scroll to the option
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionXPath);

		// Click the option to select it
		optionXPath.click();
	}

	public static void selectDropdownOptionAngular(WebDriver driver, WebElement dropdown, WebElement option) {
		// Initialize your WebDriver and JavascriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		// Find the dropdown and click it to open it
		//dropdown.click();

		// Find the option within the dropdown
		// Use a loop to scroll down until the option is in view
		while (!option.isDisplayed()) {
			jse.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", dropdown);
		}

		// Click the option to select it
		option.click();
	}

	public static void selectAndScrollTest(WebDriver driver,WebElement test, String xpath, WebElement element) {
		// Find the dropdown and option elements

		//Click the dropdown to open it

		test.click();

		WebElement div = driver.findElement(By.xpath(xpath));

		// Use JavaScript to scroll to the option
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Click the option to select it
		element.click();
	}

	public static void sendKeysJs(WebDriver driver, WebElement element, String text) {

		JavascriptExecutor jse = (JavascriptExecutor)driver;

		// Use JavascriptExecutor to send keys
		jse.executeScript("arguments[0].value='" + text + "';", element);

		System.out.println("Successfully Sent the following keys: '" + text + "' to element: " + "<"
				+ element.toString() + "> ");
	}





	public static void pause(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitAndClickElement(WebDriver driver, WebElement element)
			throws InterruptedException, IOException {
		boolean clicked = false;
		String elementAsString = element.toString();
		int attempts = 0;
		while (!clicked && attempts < 10) {
			try {
				new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element)).click();
				System.out.println("Successfully clicked on the WebElement: " + "<" + elementAsString + ">");
				// log.debug("Successfully clicked on the WebElement: " + "<" +
				// element.toString() + ">");
				// element.click();
				clicked = true;
			} catch (Exception e) {
				System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
				Assert.fail(
						"Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
			}
			attempts++;
		}
	}

	public static boolean WaitUntilWebElementClickable(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
			log.debug("WebElement is clickable using locator: " + "<" + element.toString() + ">");
			System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
			return false;
		}
	}

	public static boolean WaitUntilWebElementIsVisible(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
			log.debug("WebElement is visible using locator: " + "<" + element.toString() + ">");
			System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			// Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public static void sendKeysToWebElement(WebDriver driver, WebElement element, String textToSend) throws Exception {
		try {
			WaitUntilWebElementIsVisible(driver, element);
			element.clear();
			element.sendKeys(textToSend);
			log.debug("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"
					+ element.toString() + ">");
			System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"
					+ element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to locate WebElement: " + "<" + element.toString()
					+ "> and send the following keys: " + textToSend);
			// Assert.fail("Unable to send keys to WebElement, Exception: " +
			// e.getMessage());
		}
	}

	public static void sendKeysToWebElement(WebDriver driver, WebElement element, Keys value) {
		try {
			WaitUntilWebElementIsVisible(driver, element);
			element.clear();
			element.sendKeys(value);
			log.debug("Successfully Sent the following keys: '" + value + "' to element: " + "<" + element.toString()
					+ ">");
			System.out.println("Successfully Sent the following keys: '" + value + "' to element: " + "<"
					+ element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to locate WebElement: " + "<" + element.toString()
					+ "> and send the following keys: " + value);
			// Assert.fail("Unable to send keys to WebElement, Exception: " +
			// e.getMessage());
		}

	}

	public static String getText(WebDriver driver, WebElement element) {
		String strText = null;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
			strText = element.getText().trim();
			log.debug("Text with in the Element: " + "<" + strText + ">");
			System.out.println("Text with in the Element: " + "<" + strText + ">");
			return strText;
		} catch (NullPointerException e) {
			System.out.println(
					"unable to get the text from the WebElement using locator: " + "<" + element.toString() + ">");
		}
		return strText;
	}

}
