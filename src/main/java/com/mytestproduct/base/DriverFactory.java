package com.mytestproduct.base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	//Singleton design Pattern
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
	}
	
	
	static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverref) {
		driver.set(driverref);
	}
	
	public void unload() {
		driver.get().quit();
		driver.remove();
	}
}
