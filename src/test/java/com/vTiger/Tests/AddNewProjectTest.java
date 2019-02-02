package com.vTiger.Tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.BaseClass.BaseClass;
import com.vTiger.Pages.DashboardPage;
import com.vTiger.Pages.LoginPage;
import com.vTiger.Pages.ProjectPage;
import com.vTiger.Pages.createNewProjectPage;
import com.vTiger.Utility.testUtil;

public class AddNewProjectTest extends BaseClass {

	LoginPage login;
	DashboardPage dashboard;
	ProjectPage project;
	createNewProjectPage newProject;

	public AddNewProjectTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		login = new LoginPage();
		dashboard = login.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = new DashboardPage();
		dashboard.clickonProject();
		project = new ProjectPage();
		newProject = project.clickOnAddProject();
	}

	// DATAPROVIDER METHOD WHICH GET A DATA FROM EXCEL SHEET AND PASS IT TO APPLICATION
	@DataProvider
	public Object[][] getExcelSheetDataVikas() {
		Object[][] data = testUtil.getData("C://Users/nitin1/Desktop/Project Test Data.xlsx", "Project");
		return data;
	}

	@Test(dataProvider = "getExcelSheetDataVikas")
	public void AddProjectDataTest(Map<String, String> param) {
		newProject.SaveProject(param.get("ProjectName"), 3, param.get("Description"));
	}

	// PROVIDE DATA USING HARD CODED VALUE
	@Test
	public void addProjectTest() {
		newProject.SaveProject("FPPA", 2, "abc");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
