package com.mytestproduct.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.mytestproduct.actiondriver.ActionClass;
import com.mytestproduct.reports.ExtentFactory;

public class CoreProductFeaturePage extends BaseFactoryPage {
	WebDriver driver;

	@FindBy(xpath = "//h3[text()='VIDEOS']")
	private WebElement videoSectionHeader;

	@FindBy(xpath = "//h3[text()='VIDEOS']/parent::div/following-sibling::div[@class='ContentGrid_contentGrid__MwtcV content-grid  ']//li")
	private List<WebElement> videosList;

	@FindBy(xpath = "//h3[text()='VIDEOS']/parent::div/following-sibling::div[@class='ContentGrid_contentGrid__MwtcV content-grid  ']//li//h3")
	private List<WebElement> videosTitle;

	@FindBy(xpath = "//h3[text()='VIDEOS']/parent::div/following-sibling::div[@class='ContentGrid_contentGrid__MwtcV content-grid  ']//li//time//span")
	private List<WebElement> videoDayCount;

	public CoreProductFeaturePage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Description: Method to Scroll To Video Section Header
	 */
	public void scrollToVideosSection() {
		ActionClass.scrollToSpecificElement("Video Section Header", videoSectionHeader);
	}

	/*
	 * Description: Get the Total Number of Videos present in video section
	 */
	public void getVideoSectioncount(String expectedVideoCount) {
		int videoList = videosList.size();
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"Total Number of Videos Present In the Video Section" + " " + videoList);

		Assert.assertEquals(Integer.parseInt(expectedVideoCount), videoList);

		ArrayList<String> videoTitles = new ArrayList<String>();
		for (int i = 0; i < videosTitle.size(); i++) {
			videoTitles.add(videosTitle.get(i).getText());
		}

		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"Video Title of all the Videos present in the video section" + "\n" + videoTitles);

	}

	/*
	 * Description: Get the Count of Videos present in video section which is
	 * greater than 3 days
	 */
	public void getVideoDaysCountGreaterThan3Days(String daysCountExpectedValue) {
		int count = 0;
		List<Integer> daysArray = new ArrayList<Integer>();

		// Iterating through each element
		for (WebElement e : videoDayCount) {
			String dayValue = e.getText();

			// Iterating the string and adding only digit values into the array
			for (int i = 0; i < dayValue.length(); i++) {
				if (dayValue.charAt(i) == 'd') {
					daysArray.add(Integer.parseInt(dayValue.substring(0, i)));
				}
			}

		}

		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"Day Values of entire Video List In the Video Section" + " " + daysArray);

		// Iterating through the array and counting the videos which is greater than 3
		// days
		for (int i = 0; i < daysArray.size(); i++) {
			if (daysArray.get(i) > Integer.parseInt(daysCountExpectedValue)) {
				count++;
			}
		}
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"Total Number of Videos Present In the Video Section which is Greater than 3 Days" + " " + count);

	}

}
