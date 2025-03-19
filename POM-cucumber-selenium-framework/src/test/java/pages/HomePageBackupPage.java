package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriverClass;

public class HomePageBackupPage extends BaseDriverClass {

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	@CacheLookup
	private WebElement homepageHeader;

	private WebDriver driver;

	public HomePageBackupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
