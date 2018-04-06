package com.bank.test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.common.Base;
import com.common.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class BankTestSuite extends BaseTest {
	
	
	@Test
	public void VerifyGuestUserLogin() throws InterruptedException
	{
		System.out.println("\n-------------------- IN BANK - APPLICATION TESTCASES ----------------------------");
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: VerifyGuestUserLogin");
		bilM.VerifyGuestUserLogin();
		System.out.println("Completed execution of :: VerifyGuestUserLogin");
		System.out.println("-----------------------------------------------------------------\n");
	}
	
	//@Test
	public void VerifyCustomerUserLogin() throws InterruptedException
	{
		System.out.println("\n-------------------- IN BANK - APPLICATION TESTCASES ----------------------------");
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: VerifyCustomerUserLogin");
		bilM.VerifyCustomerUserLogin();
		System.out.println("Completed execution of :: VerifyCustomerUserLogin");
		System.out.println("-----------------------------------------------------------------\n");
	}
	
	//@Test
	public void VerifyComponentsOnBankHomePage() throws InterruptedException, IOException
	{
		
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: VerifyComponentsOnBankHomePage");
		bilM.VerifyComponentsOnBankHomePage();
		System.out.println("Completed execution of :: VerifyComponentsOnBankHomePage");
		System.out.println("-----------------------------------------------------------------\n");
	}
	
	
	//@Test
	public void test7(){
	
		BankTestMethods cilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: test7");
		//cilM.VerifyTest7();
		System.out.println("Completed execution of :: test7");
		System.out.println("-----------------------------------------------------------------\n");
	
		
	}
	
		
	
	
}
