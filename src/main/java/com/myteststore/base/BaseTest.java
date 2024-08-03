package com.myteststore.base;

import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.myteststore.utilities.PropertyFile;

public class BaseTest {

	/*
	 * Function Description: Method to Launch , Maximize the Browser and Launch
	 * Application URL
	 */
	@BeforeTest
	public void launchApplication() {
		DriverFactory.getInstance().setDriver(BrowserFactory.launchBrowser(PropertyFile.getPropertyValue("browser")));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		DriverFactory.getInstance().getDriver().navigate().to(PropertyFile.getPropertyValue("url"));
	}

	/*
	 * Function Description: Method to close the browser
	 */
	@AfterTest
	public void tearDown() {
		DriverFactory.getInstance().unload();
	}
}
