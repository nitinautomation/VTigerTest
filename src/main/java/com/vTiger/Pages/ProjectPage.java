package com.vTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.BaseClass.BaseClass;

public class ProjectPage extends BaseClass {
	@FindBy(id="Project_listView_basicAction_LBL_ADD_RECORD")
	WebElement addProjectLink;
	
	@FindBy(id="Project_basicAction_LBL_IMPORT")
	WebElement importLink;
	
	@FindBy(id="btn btn-default module-buttons dropdown-toggle")
	WebElement CustomizeLink;
	public ProjectPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public createNewProjectPage clickOnAddProject(){
		 addProjectLink.click();
		return new createNewProjectPage();
	}
	
}
