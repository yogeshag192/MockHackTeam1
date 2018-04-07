package com.common;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {
	public static WebDriver driver;
	public Properties appProperties;
	public static Properties webElementProperties;

	public Base(WebDriver driver) {
		this.driver = driver;
		Base.webElementProperties = PropertiesUtil.getWebElementProperties();
		this.appProperties = PropertiesUtil.getAppProperties();
	}

	public void launchURL(String url) throws InterruptedException {

		System.out.println("Opening URL: " + url);
		driver.get(appProperties.getProperty(url));
		waitForPageToLoad("60");
		driver.manage().window().maximize();
		System.out.println("Title of URL is " + driver.getTitle());
		Thread.sleep(2000);
	}

	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	public String getElementValue(String propertyName) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Files\\webElement.properties");
		appProperties = new Properties();
		appProperties.load(fis);
		return appProperties.getProperty(propertyName);
	}

	public String getInputValue(String propertyName) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Files\\input.properties");
		appProperties = new Properties();
		appProperties.load(fis);
		return appProperties.getProperty(propertyName);

	}

	public By parseLocator(String webElementProperty) {
		By by = null;
		String locatorType = webElementProperty.substring(0, 2);
		String elementId = webElementProperty.substring(3, webElementProperty.length() - 1);

		System.out.println("Current Element id : " + elementId);
		if (locatorType.equals("xp")) // xpath
		{
			by = By.xpath(elementId);
		} else if (locatorType.equals("id")) // id
		{
			by = By.id(elementId);
		} else if (locatorType.equals("nm")) // name
		{
			by = By.name(elementId);
		} else if (locatorType.equals("cl")) // className
		{
			by = By.className(elementId);
		} else if (locatorType.equals("lt")) // linkText
		{
			by = By.linkText(elementId);
		} else if (locatorType.equals("pt")) // partialLinkText
		{
			by = By.partialLinkText(elementId);
		} else if (locatorType.equals("cs")) // cssSelector

		{
			by = By.cssSelector(elementId);
		} else if (locatorType.equals("tg")) // tagName
		{
			by = By.tagName(elementId);
		} else {
			System.out.println("Cannot identify locator Type");
		}
		return by;
	}

	public WebElement findElement(String webElementProperty) {
		By by = parseLocator(webElementProperty);
		WebElement ele = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		ele = wait.until(ExpectedConditions.elementToBeClickable(by));
		return ele;
	}

	public void type(String locator, String text) throws InterruptedException {
		By by = parseLocator(locator);
		WebElement ele = driver.findElement(by);
		ele.click();
		System.out.println("Clicked into Textbox "+locator);
		Thread.sleep(1000);
		ele.sendKeys(text);
	}

	public void waitForElementToBeVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parseLocator(locator)));
	}

	public boolean isElementPresentAndDisplayed(String locator) {
		By by = parseLocator(locator);
		WebElement ele = driver.findElement(by);
		if (ele.isDisplayed() && ele.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}
	


	public boolean isElementPresentAndDisplayed(WebElement ele) {
		if (ele.isDisplayed() && ele.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	public void waitForElementToBeClickable(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(parseLocator(locator)));
	}

	public void clickElement(String locator) {
		By by = parseLocator(locator);
		WebElement element = driver.findElement(by);
		if (element == null || (!element.isEnabled())) {
			fail("Did not find element to click : " + element.getAttribute("id"));
		}
		WebDriverWait wait = new WebDriverWait(driver, 120);
		element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
	

	}

	public void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 60);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
	}

	public void waitForPageToLoad(String timeOutInSeconds) {
		String windowTitle = driver.getTitle();
		int time = Integer.parseInt(timeOutInSeconds);
		int pageLength = 0;
		for (int second = 0;; second++) {
			if (second >= time) {
				fail("Timeout... Page load could not complete in " + timeOutInSeconds + " seconds");
			}
			if (pageLength == driver.getPageSource().length() && windowTitle != driver.getTitle()) {
				break;
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pageLength = driver.getPageSource().length();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}

	}

}
