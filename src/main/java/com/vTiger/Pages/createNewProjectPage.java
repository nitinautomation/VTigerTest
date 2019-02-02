package com.vTiger.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vTiger.BaseClass.BaseClass;

public class createNewProjectPage extends BaseClass {
		
	@FindBy(id="Project_editView_fieldName_projectname")
	WebElement ProjectNameTxt;
	
	@FindBy(xpath="//input[@data-fieldname='targetbudget']")
	WebElement ProjectBudgeTxt;
	
	@FindBy(id="Project_editView_fieldName_description")
	WebElement DescriptionTxt;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement SaveBtn;
	
	public createNewProjectPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void SaveProject(String ProjName, Integer assignedTo, String ProjDesc){
		
		ProjectNameTxt.sendKeys(ProjName);
		//Select select = new Select(driver.findElement(By.xpath("(//span[@class='select2-chosen' ])[1]")));
		//select.selectByVisibleText(AssignedTo);
		 List<WebElement> options = driver.findElements(By.className("select2-chosen"));
		options.get(assignedTo).click();
		
		//ProjectBudgeTxt.sendKeys(ProjBudget);
		DescriptionTxt.sendKeys(ProjDesc);
		SaveBtn.submit();
		
		
	}
	
	
	
}
