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
	
	public void VerifyGuestUserLogin() throws InterruptedException, IOException{
		
		launchURL("mockURL");
		BaseTest.test.log(LogStatus.INFO,  driver.getTitle() +" : is verified");
		BaseTest.test.log(LogStatus.PASS, "Successfully Launched the Website!");
		type(getElementValue("usernametextbox"), "abc123");
		type(getElementValue("passwordtextbox"), "abc@123");
	
		
	}
	
	public void VerifyCustomerUserLogin() throws IOException, InterruptedException{
		
		clickElement(getElementValue("sign_inButton"));
		waitForElementToBeClickable("sign_inButton");
		
	}
	
	public void VerifyComponentsOnBankHomePage() throws IOException, InterruptedException{
		
		BaseTest.test.log(LogStatus.INFO, "-----Verifying Components on the Home Page..");
		isElementPresentAndDisplayed("Amounttextbox");
		WebElement verifyAmount= findElement(getElementValue("Amounttextbox"));
		 String Amounttext = verifyAmount.getText();
		BaseTest.test.log(LogStatus.INFO,   Amounttext+" : is verified");
		BaseTest.test.log(LogStatus.PASS, "Successfully Verified AmounttextBox component on the Website!");
		
		isElementPresentAndDisplayed(getElementValue("tenuredropdown"));
		BaseTest.test.log(LogStatus.PASS, "Successfully Verified tenure component on the Website!");
		
		
	}


	public void ApplyLoan() throws InterruptedException, IOException{
		
	
		
	}
	
	public void VerifyComponentsOnApplyLoanpage() throws InterruptedException, IOException{
		
		
	}
	
public void BankAuthorityPage() throws InterruptedException, IOException{
		
		
	
		
	}
		
public void VerifyComponentsOnBankPage() throws InterruptedException, IOException{
	
	
}

public void verifycalculateEMI() throws InterruptedException, IOException{
	

}
	
}
