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
import org.testng.Assert;

import com.common.Base;
import com.common.BaseTest;
import com.common.ExtentReportSetup;
import com.relevantcodes.extentreports.LogStatus;

public class BankTestMethods extends Base{

	public BankTestMethods(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//Test Case Methods start here
	
	public void VerifyGuestUserLogin() throws InterruptedException{
		
		launchURL("mockURL");
		BaseTest.test.log(LogStatus.INFO,  driver.getTitle() +" : is verified");
		BaseTest.test.log(LogStatus.PASS, "Successfully Launched the Website!");
		
		
		
	}
	
	public void VerifyCustomerUserLogin(){
		
	}
	
	public void VerifyComponentsOnBankHomePage() throws IOException, InterruptedException{
		
		BaseTest.test.log(LogStatus.INFO, "-----Verifying Components on the Home Page..");
		
		
	}
	
}
