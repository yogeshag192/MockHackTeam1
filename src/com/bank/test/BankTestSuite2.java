package com.bank.test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.common.Base;
import com.common.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class BankTestSuite2 extends BaseTest {
	
	
	@Test
	public void zverifyBankAuthorityPage() throws InterruptedException, IOException{
		
		BankTestMethods bilM = new BankTestMethods(driver);
		System.out.println("Started execution of :: verifyBankAuthorityPage");
		bilM.BankAuthorityPage();
		System.out.println("Completed execution of :: verifyBankAuthorityPage");
		System.out.println("-----------------------------------------------------------------\n");
	
		
	}

}
