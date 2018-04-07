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
	public void verifycalculateEMI() throws InterruptedException, IOException{
		
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: verifycalculateEMI");
		bilM.verifycalculateEMI();
		System.out.println("Completed execution of :: verifycalculateEMI");
		System.out.println("-----------------------------------------------------------------\n");
	
	}
	
	
	@Test (dependsOnMethods="verifycalculateEMI")
	public void VerifyCustomerUserLogin() throws InterruptedException, IOException
	{
		System.out.println("\n-------------------- IN BANK - APPLICATION TESTCASES ----------------------------");
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: VerifyCustomerUserLogin");
		bilM.VerifyCustomerUserLogin();
		System.out.println("Completed execution of :: VerifyCustomerUserLogin");
		System.out.println("-----------------------------------------------------------------\n");
	}
	
	
	@Test(dependsOnMethods = "VerifyCustomerUserLogin")
	public void verifyApplyLoan() throws InterruptedException, IOException{
	
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: verifyApplyLoan");
		bilM.ApplyLoan();
		System.out.println("Completed execution of :: verifyApplyLoan");
		System.out.println("-----------------------------------------------------------------\n");
		
	}
	

}
