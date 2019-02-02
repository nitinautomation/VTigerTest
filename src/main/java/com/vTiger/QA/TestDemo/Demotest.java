package com.vTiger.QA.TestDemo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Demotest {
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C://Users/nitin1/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.netflix.com");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");

		 
	}
}
