package com.mytestproduct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mytestproduct.actiondriver.ActionClass;

public class CoreProductHomePage extends ActionClass {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='text-red-100 InsiderPopup_modal__QyNvR']//div[@class='w-full flex flex-end']/div")
	private WebElement ticketAccessCloseIcon;

	@FindBy(id = "onetrust-banner-sdk")
	private WebElement privacyPopup;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement privacyPopupAcceptBtn;
	
	@FindBy(xpath = "//ul[@class='_menu_1d1mm_114']//a/span[text()='...']")
	private WebElement secondaryMenu;
	
	@FindBy(xpath = "//ul[@class='_menu_1d1mm_114']//ul[@class='_list_1c46u_44']/li/a[text()='News & Features']")
	private WebElement newsAndFeaturesPage;
	
	

	public CoreProductHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Description: Method to click Ticket Access Popup Close Icon
	 */
	public void closeTicketAccessPopUp() {
		click("ticketAccessCloseIcon", ticketAccessCloseIcon);
		mouseHoveronElement("secondaryMenu",secondaryMenu);
		mouseHoveronElement("newsAndFeaturesPage",newsAndFeaturesPage);
		click("newsAndFeaturesPage", newsAndFeaturesPage);
		

	}
	
	

}
