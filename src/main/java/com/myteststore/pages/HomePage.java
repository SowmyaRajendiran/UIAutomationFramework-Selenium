package com.myteststore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myteststore.actiondriver.ActionClass;

public class HomePage extends ActionClass{
	WebDriver driver;

	@FindBy(xpath = "//a[@class='login']")
	private WebElement buttonSignIn;
	
	@FindBy(xpath="//a[text()='Blog']")
	private WebElement blog;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Description: Method to click Sign In Button In Home Page
	 */
	public void clicksignin() {
		 click("clcik" , buttonSignIn);
		System.out.println("welcome");

	}
	
	public void blog() {
		 blog.isDisplayed();
		 System.out.println("hi");
		 click("clcik" , blog);

	}


}
