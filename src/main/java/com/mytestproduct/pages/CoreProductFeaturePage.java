package com.mytestproduct.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mytestproduct.actiondriver.ActionClass;

public class CoreProductFeaturePage extends ActionClass {
	WebDriver driver;

	@FindBy(xpath = "//h3[text()='VIDEOS']")
	private WebElement videoHeader;

	@FindBy(xpath = "//h3[text()='VIDEOS']/parent::div/following-sibling::div//ul/li")
	private List<WebElement> videosList;

	@FindBy(xpath = "//h3[text()='VIDEOS']/parent::div/following-sibling::div//ul/li//div[@class='TileArticle_tileArticleMetaWrapper__431v8']//time/span")
	private List<WebElement> videoTimeCount;

	public CoreProductFeaturePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Description: Method to click Ticket Access Popup Close Icon
	 */
	public void scrollToVideosSection() {
		scrollToSpecificElement("videoHeader", videoHeader);
	}

	public void getVideoSectioncount() {

		int videoList = videosList.size();
		System.out.println("count of videos present in news and features page is" + videoList);

	}

	public void getVideoDayscount() {
		int expValue = 3;
		int count = 0;
		List<Integer> arr = new ArrayList<Integer>();

		for (WebElement e : videoTimeCount) {
			String dayValue = e.getText();

			for (int i = 0; i < dayValue.length(); i++) {
				if (dayValue.charAt(i) == 'd') {
					arr.add(Integer.parseInt(dayValue.substring(0, i)));
				}
			}

		}

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > expValue) {
				count++;
			}
		}
		System.out.println("Days array" + arr);
		System.out.println("Total Videos greater than 3d is" + count);

	}

}
