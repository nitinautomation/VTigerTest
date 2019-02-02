package com.vTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.BaseClass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameTxt;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTxt;

	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signInBtn;

	@FindBy(xpath = "//a[text()='forgot password?']")
	WebElement forgotPwLink;

	@FindBy(xpath = "//img[@class='img-responsive user-logo']")
	WebElement vTigerLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatevTigerLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateVTigerLogo() {
		return vTigerLogo.isDisplayed();
	}
	//Login to vtiger demo
	public DashboardPage login(String un, String pass) {
		usernameTxt.sendKeys(un);
		passwordTxt.sendKeys(pass);
		signInBtn.click();
		return new DashboardPage();
	}
}
