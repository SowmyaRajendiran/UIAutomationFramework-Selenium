package com.mytestproduct.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mytestproduct.actiondriver.ActionClass;

import org.apache.commons.csv.CSVFormat;

public class DerivedProductPage extends ActionClass {
	WebDriver driver;

	@FindBy(xpath = "//footer[contains(@class,'text-xs text-white dark-primary-background')]//a")
	private List<WebElement> footerHyperlinks;

	@FindBy(xpath = "//div[contains(@id,'homepage_bottom')]")
	private WebElement homePageBottomSection;

	public DerivedProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Description: Method to click Ticket Access Popup Close Icon
	 */
	public void getListofFooterHyperlinks() {
		scrollToSpecificElement("Footer Section", homePageBottomSection);

		for (WebElement e : footerHyperlinks) {
			String ele = e.getAttribute("href");
			System.out.println(ele);
		}

	}

	/*
	 * Description: Method to click Ticket Access Popup Close Icon
	 */
	public void verifyLinks() throws IOException {
		FileWriter writer = new FileWriter("file.csv");
		scrollToSpecificElement("Footer Section", homePageBottomSection);
		// Use Sets to store links and detect duplicates
		Set<String> linkSet = new HashSet<String>();
		Set<String> duplicateLinks = new HashSet<String>();

		for (WebElement link : footerHyperlinks) {
			String href = link.getAttribute("href");
			if (href != null && !href.isEmpty()) {
				// Check for duplicates
				if (!linkSet.add(href)) {
					duplicateLinks.add(href);
				} else {
					linkSet.add(href);
					writer.append(href+"\n");
				}
			}
		}
		System.out.println(linkSet);

		// Report duplicates
		if (!duplicateLinks.isEmpty())

		{
			System.out.println("Duplicate links found:");
			for (String duplicate : duplicateLinks) {
				System.out.println(duplicate);
			}
		} else {
			System.out.println("No duplicate links found.");
		}

		writer.close();
	}
}
