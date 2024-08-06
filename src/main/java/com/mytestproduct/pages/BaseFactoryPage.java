package com.mytestproduct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseFactoryPage {
	protected WebDriver driver;

	// Base constructor for initializing web elements
	public BaseFactoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
