package com.vTiger.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.vTiger.Utility.testUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static com.vTiger.Utility.WebEventListener eventListener;
	private static EventFiringWebDriver event_driver;
	Logger log = Logger.getLogger(BaseClass.class);
	


	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("G:/kayan tech solution/VTigerTestDemo/src/main/java/com/"
					+ "vTiger/Configuration/config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//OPEN BROWSER AS SPECIFY IN PROPERTIES FILE
	public static void initilization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//To Generate Event
		event_driver = new EventFiringWebDriver(driver);
		eventListener = new com.vTiger.Utility.WebEventListener();
		event_driver.register(eventListener);
		driver = event_driver;

		
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(testUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.implicit_wait, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		driver.navigate().to(prop.getProperty("url"));
	}
}
