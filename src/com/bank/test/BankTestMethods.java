package com.bank.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.common.Base;
import com.common.BaseTest;
import com.common.ExtentReportSetup;
import com.relevantcodes.extentreports.LogStatus;

public class BankTestMethods extends Base {

	public BankTestMethods(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Test Case Methods start here
	
	public void verifycalculateEMI() throws InterruptedException, IOException {
		launchURL("mockURL");
		BaseTest.test.log(LogStatus.INFO, "Title: " + driver.getTitle() + " : is verified");
		BaseTest.test.log(LogStatus.PASS, "Successfully Launched the Website!");
		type(getElementValue("Amounttextbox"), "2500000");
		Select select = new Select(driver.findElement(By.xpath("//*[@id='tenure']")));
		select.selectByVisibleText("20");
		Thread.sleep(2000);
		clickElement(getElementValue("submitEMIButton"));
		Thread.sleep(4000);
		String EMi = driver.findElement(By.xpath("//div[@class= 'message']/h4")).getText();
		System.out.println(EMi);
		BaseTest.test.log(LogStatus.PASS, "EMI Calculated!");

	}

	public void VerifyCustomerUserLogin() throws InterruptedException, IOException {

		launchURL("mockURL");
		BaseTest.test.log(LogStatus.INFO, driver.getTitle() + " : is verified");
		BaseTest.test.log(LogStatus.PASS, "Successfully Launched the Website!");
		type(getElementValue("usernametextbox"), getInputValue("mockUsername"));
		type(getElementValue("passwordtextbox"), getInputValue("mockPassword"));
		clickElement(getElementValue("sign_inButton"));
		Thread.sleep(5000);
		System.out.println("User Logged in successfully..");
		BaseTest.test.log(LogStatus.PASS, "Verified user logged in successfully.");

	}

	public void ApplyLoan() throws InterruptedException, IOException {
		clickElement(getElementValue("applyLoanLink"));
		waitForPageToLoad("60");
		type(getElementValue("amountApplyLoan"), "3500000");
		Select select = new Select(driver.findElement(By.xpath("//*[@id='tenure']")));
		select.selectByVisibleText("20");
		clickElement(getElementValue("applyLoanButton"));
		Thread.sleep(6000);
		String status = driver.findElement(By.xpath("//div[@class= 'message']/h4")).getText();
		System.out.println(status);
		Thread.sleep(6000);
		BaseTest.test.log(LogStatus.PASS, "ApplyLoan Verified successfully.");
		driver.findElement(By.xpath("//a[contains(text(),'See Approvals')]")).click();
		Thread.sleep(8000);
		
		
	}

	public void BankAuthorityPage() throws InterruptedException, IOException {
		
		launchURL("mockURL");
		BaseTest.test.log(LogStatus.INFO, driver.getTitle() + " : is verified");
		BaseTest.test.log(LogStatus.PASS, "Successfully Launched the Website!");
		type(getElementValue("usernametextbox"), getInputValue("adminUser"));
		type(getElementValue("passwordtextbox"), getInputValue("adminPassword"));
		clickElement(getElementValue("sign_inButton"));
		Thread.sleep(2000);
		clickElement(getElementValue("sign_inButton"));
		Thread.sleep(5000);
		System.out.println("User Logged in successfully..");
		BaseTest.test.log(LogStatus.PASS, "Admin User login Verified successfully.");
		
		driver.findElement(By.xpath("//a[contains(text(),'Loan requests')]")).click();
		Thread.sleep(8000);
		BaseTest.test.log(LogStatus.PASS, "Loan Requests Verified successfully.");
		
		
	}


	

}
