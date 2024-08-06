package com.mytestproduct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mytestproduct.actiondriver.ActionClass;
import com.mytestproduct.base.DriverFactory;

public class CoreProductHomePage extends BaseFactoryPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='text-red-100 InsiderPopup_modal__QyNvR']//div[@class='w-full flex flex-end']/div")
	private WebElement ticketAccessPopUpCloseIcon;

	@FindBy(id = "onetrust-banner-sdk")
	private WebElement privacyPopup;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement privacyPopupAcceptBtn;

	@FindBy(xpath = "//ul[@class='_menu_1d1mm_114']//a/span[text()='...']")
	private WebElement secondaryMenu;

	@FindBy(xpath = "//ul[@class='_menu_1d1mm_114']//ul[@class='_list_1c46u_44']/li/a[text()='News & Features']")
	private WebElement newsAndFeaturesPage;

	public CoreProductHomePage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Description: Method to Verify The Page Title
	 */
	public void verifyPageTitle(String expectedTitle) {
		ActionClass.verifyPageTitle(expectedTitle);
	}

	/*
	 * Description: Method to click Ticket Access Popup Close Icon
	 */
	public void verifyTicketAccessPopUp() {
		ActionClass.click("Close Icon - Ticket Access Popup", ticketAccessPopUpCloseIcon);
	}

	/*
	 * Description: Method to Navigate to News and Features Page from Home Page
	 */
	public void navigateToNewsAndFeaturesSubMenu() {
		ActionClass.mouseHoveronElement("Secondary Menu - '...'", secondaryMenu);
		ActionClass.mouseHoveronElement("NewsAndFeatures Sub Menu", newsAndFeaturesPage);
		ActionClass.click("NewsAndFeatures Sub Menu", newsAndFeaturesPage);

	}

}
