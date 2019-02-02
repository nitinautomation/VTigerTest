package com.vTiger.Tests;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vTiger.BaseClass.BaseClass;
import com.vTiger.Pages.LoginPage;
import com.vTiger.Utility.testUtil;


public class LoginPageTest extends BaseClass {

	LoginPage login;

	// INVOKE THE CONSTRUCTOR OF SUPER CLASS
	public LoginPageTest() {
		super();
	}

	// LANUCH BROWSER AND OPEN URL
	@BeforeMethod
	public void launchBrowser() {
		initilization();
		login = new LoginPage();
	}

	// VERIFY LOGIN PAGE TITLE
	@Test(priority = 2)
	public void loginPageTitleTest() {
		String LoginPageTitle = login.validatevTigerLoginPageTitle();
		Assert.assertEquals(LoginPageTitle, "vtiger1", "lOGIN PAGE TITILE DOES NOT MATCH WITH EXPECTED");
	}

	// VERIFY LOGIN PAGE LOGO IS PRESENT OR NOT
	@Test(priority = 1)
	public void validateLoginPageLogo() {
		boolean VTigerLogo = login.validateVTigerLogo();
		Assert.assertTrue(VTigerLogo);
	}

	// LOGIN INTO VTIGER
	@Test
	public void loginTest() {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if(ITestResult.FAILURE == result.getStatus()){
			testUtil.captureFailureScreenshot(result.getName());
		}
		
		driver.close();
	}
}
