package pages;

import helper.Constants;
import helper.SeleniumUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import utils.BaseDriverClass;

import java.io.File;
import java.io.IOException;

public class LoginPage extends BaseDriverClass {


	@FindBy(id = "username")
	@CacheLookup
	private WebElement usernameField;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement passwordField;

	@FindBy(className = "button")
	@CacheLookup
	private WebElement loginButton;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToSite() throws Exception {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		SeleniumUtils.waitAndClickElement(driver, usernameField);
		SeleniumUtils.sendKeysToWebElement(driver, usernameField, Constants.getUsername());
		SeleniumUtils.waitAndClickElement(driver, passwordField);
		SeleniumUtils.sendKeysToWebElement(driver, passwordField, Constants.getPassword());
		SeleniumUtils.waitAndClickElement(driver, loginButton);
	}
}
