package com.mytestproduct.base;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.mytestproduct.utilities.PropertyFile;

public class BaseTest {

	/*
	 * Function Description: Method to Launch , Maximize the Browser and Launch
	 * Application URL
	 */
	public void launchApplication(String urlKey) {
		DriverFactory.getInstance().setDriver(BrowserFactory.launchBrowser(PropertyFile.getPropertyValue("browser")));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		DriverFactory.getInstance().getDriver().navigate().to(PropertyFile.getPropertyValue(urlKey));
	}
	/*
	 * Function Description: Method to close the browser
	 */
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().unload();
	}
}
