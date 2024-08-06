package com.mytestproduct.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.mytestproduct.actiondriver.ActionClass;
import com.mytestproduct.reports.ExtentFactory;

public class DerivedProductPage extends BaseFactoryPage {
	WebDriver driver;
	Set<String> duplicateLinks = new HashSet<String>();

	@FindBy(xpath = "//footer[contains(@class,'text-xs text-white dark-primary-background')]")
	private WebElement footerSection;

	@FindBy(xpath = "//footer[contains(@class,'text-xs text-white dark-primary-background')]//a")
	private List<WebElement> footerHyperlinks;

	@FindBy(xpath = "//div[contains(@id,'homepage_bottom')]")
	private WebElement derivedproductPageBottomSection;

	public DerivedProductPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Description: Method to Navigate To Footer Section
	 */
	public void navigateToFooterSection() {
		ActionClass.scrollToSpecificElement("Derived Product Page Footer Section", footerSection);
	}

	/*
	 * Description: Method to Get The List of HyperLinks In Footer Section Ans Store
	 * It In CSV File
	 */
	public void verifyHyperLinksInFooterSectionAndStoreItInCSV(String expectedHyperLinksCount) throws IOException {
		FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/test/resources/csvFile/links.csv");
		
		Assert.assertEquals(Integer.parseInt(expectedHyperLinksCount), footerHyperlinks.size());

		// Use Sets to store links and detect duplicates
		Set<String> linkSet = new HashSet<String>();

		for (WebElement link : footerHyperlinks) {
			String href = link.getAttribute("href");
			if (href != null && !href.isEmpty()) {
				// Check for duplicates
				if (!linkSet.add(href)) {
					duplicateLinks.add(href);
				} else {
					linkSet.add(href);
					// Store the Hyper Links in CSV File
					writer.append(href + "\n");
				}
			}
		}
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"List of HyperLinks In the Footer Section" + " " + linkSet);

		writer.close();
	}

	/*
	 * Description: Method to Get The List of HyperLinks In Footer Section And Store
	 * It In CSV File
	 */
	public void verifyDuplicateHyperLinksInFooterSection() {
		if (!duplicateLinks.isEmpty())

		{
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"List of Duplicate HyperLinks In the Footer Section" + " " + duplicateLinks);

		} else {
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Duplicate HyperLinks Are Not Present In the Footer Section" + " " + duplicateLinks);
		}

	}
	
	/*
	 * Description: Method to Verify The Page Title
	 */
	public void verifyPageTitle(String expectedTitle) {
		ActionClass.verifyPageTitle(expectedTitle);
	}

}
