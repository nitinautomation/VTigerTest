package com.vTiger.Tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vTiger.BaseClass.BaseClass;
import com.vTiger.Pages.DashboardPage;
import com.vTiger.Pages.LoginPage;

public class DashboardPageTest extends BaseClass {

	LoginPage login;
	DashboardPage Dashboard;

	public DashboardPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initilization();
		login = new LoginPage();
		Dashboard = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	//VERIFY DASHBOARD PAGE TITLE
	@Test
	public void verifyTitleofDashBoardPageTest() {
		String dashTitle = Dashboard.verifyTitle();
		Assert.assertEquals(dashTitle, "Dashboard", "Dashboard page title does not match with actual");
	}
	//VERIFY DASHBOARD LOGO IS PRESENT OR NOT
	@Test
	public void verifyDashboardLogoTest() {
		boolean logoPresent = Dashboard.verifyLogo();
		Assert.assertTrue(logoPresent, "Logo is not present");
	}
	//OPEN PROJECT MENU 
	@Test
	public void openProjectPageTest() {
		Dashboard.clickonProject();
	}
	//OPEN PROJECT TASK 
	@Test
	public void openProjectTasksTest() {
		Dashboard.clickonProjectTasks();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
