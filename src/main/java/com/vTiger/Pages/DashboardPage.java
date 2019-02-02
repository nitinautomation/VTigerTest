package com.vTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.BaseClass.BaseClass;
import com.vTiger.Utility.testUtil;

public class DashboardPage extends BaseClass {
	
	@FindBy(xpath="(//div[@class='row app-navigator'])[1]")
	WebElement settingMenu;
	
	@FindBy(xpath="//img[@src='test/logo/vtiger-crm-logo.png']")
	WebElement VTigerDashBoardLogo;
	
	@FindBy(xpath="//*[@class='keyword-input']")
	WebElement SearchText;
	
	@FindBy(id="menubar_quickCreate")
	WebElement quickCreateLink;
	
	@FindBy(xpath="//*[@class='fa fa-calendar']")
	WebElement Calender;
	
	@FindBy(xpath="fa fa-bar-chart")
	WebElement Reports;
	
	@FindBy(className="taskManagement vicon vicon-task")
	WebElement Tasks;
	
	@FindBy(xpath="//*[@class='userName dropdown-toggle']")
	WebElement adminLink;
	
	@FindBy(xpath="//button[@class='btn btn-default reArrangeTabs dropdown-toggle']")
	WebElement moreList;
	
	@FindBy(xpath="//div[@class='menu-item app-item dropdown-toggle app-item-color-PROJECT']")
	WebElement ProjectHeaderLink;
	
	@FindBy(xpath="//span[contains(text(),'Projects')]")
	WebElement ProjectsLink;
	
	@FindBy(xpath="//span[contains(text(),' Project Tasks')]")
	WebElement ProjectsTaskLink;
	
	@FindBy(xpath="//span[contains(text(),' Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(),' PBX Manager')]")
	WebElement pbxManagerLink;
	
	@FindBy(xpath="//span[contains(text(),' Organization')]")
	WebElement organizationLink;
	
	@FindBy(xpath="//h5[@class='']")
	WebElement admin;
	 public DashboardPage() {
		 PageFactory.initElements(driver, this);
	}
	 
	 public String verifyTitle(){
		 return driver.getTitle();
	 }
	 public boolean verifyLogo(){
		return VTigerDashBoardLogo.isDisplayed();
	 }
	 public boolean VerifyCorrectUserNameisDisplayedOrNot(){
		 adminLink.click();
		 return admin.isDisplayed();
	 }
	 
	public ProjectPage clickonProject(){
		settingMenu.click();
		testUtil.mouseHovourAction(ProjectHeaderLink, ProjectsLink);
		return new ProjectPage();
	}
	
	public projectTaskPage clickonProjectTasks(){
		settingMenu.click();
		testUtil.mouseHovourAction(ProjectHeaderLink, ProjectsTaskLink);
		return new projectTaskPage();
	}
	public ContactPage clickonContact(){
		settingMenu.click();
		testUtil.mouseHovourAction(ProjectHeaderLink, contactLink);
		return new ContactPage();
	}
	public PBXManagerPage clickOnPBXManager(){
		settingMenu.click();
		testUtil.mouseHovourAction(ProjectHeaderLink, pbxManagerLink);
		return new PBXManagerPage();
	}
	public PBXManagerPage ClickOnOrganization(){
		settingMenu.click();
		testUtil.mouseHovourAction(ProjectHeaderLink, organizationLink);
		return new PBXManagerPage();
	}
	
}
