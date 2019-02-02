package com.vTiger.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vTiger.BaseClass.BaseClass;
import com.vTiger.Pages.DashboardPage;
import com.vTiger.Pages.LoginPage;
import com.vTiger.Pages.ProjectPage;
import com.vTiger.Pages.createNewProjectPage;

public class ProjectPageTest extends BaseClass {
	
	LoginPage login;
	DashboardPage dashboard;
	ProjectPage project;
	createNewProjectPage newProject;
	public ProjectPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initilization();
		login = new LoginPage();
		dashboard = login.login(prop.getProperty("username"), prop.getProperty("password"));
		project = new ProjectPage();
		project = dashboard.clickonProject();
	}
	//ADD NEW PROJECT
	@Test
	public void AddNewProject(){
		project.clickOnAddProject();		
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
//		driver.quit();
	}
	
	
}
