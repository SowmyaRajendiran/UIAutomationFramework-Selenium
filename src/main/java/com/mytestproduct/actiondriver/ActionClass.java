package com.mytestproduct.actiondriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.reports.ExtentFactory;

public class ActionClass {

	/*
	 * Function Description: This function is used to Click the Specific Element In
	 * the Web Page
	 * 
	 * @parameter fieldname, element
	 */

	public static void click(String fieldName, WebElement element) {
		try {

			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(2))
					.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"The Field" + " " + "'" + fieldName + "'" + " " + "Has Been Clicked Successfully");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "The Field" + " " + "'" + fieldName + "'" + " "
					+ "Has Not Been Clicked Successfully" + e.getMessage());
		}
	}

	/*
	 * Function Description: This function is used to Verify the Page Title In the
	 * Web Page
	 * 
	 * @parameter expectedTitle
	 */

	public static void verifyPageTitle(String expectedTitle) {
		try {

			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(2))
					.until(ExpectedConditions.titleContains(expectedTitle));

			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"Expected Title" + " " + "'" + expectedTitle + "'" + " " + "Is Present");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Expected Title" + " " + "'" + expectedTitle + "'" + " " + "Is Not Present" + e.getMessage());
		}
	}

	/*
	 * Function Description: This function is used to Scroll To Specific Element In
	 * the Web Page
	 * 
	 * @parameter fieldname, element
	 */
	public static void scrollToSpecificElement(String fieldName, WebElement element) {
		try {

			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(element));

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"The User Has Been Scrolled to the" + " " + "'" + fieldName + "'" + " " + "Successfully");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "The User Has Not Been Scrolled to the" + " " + "'"
					+ fieldName + "'" + " " + "Successfully" + e.getMessage());
		}
	}

	/*
	 * Function Description: This function is used to Enter the text In the Text Box
	 * 
	 * @parameter fieldname, element, value
	 */
	public static void enterText(String fieldName, WebElement element, String value) {
		try {

			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(element));

			Actions action = new Actions(DriverFactory.getInstance().getDriver());
			action.sendKeys(Keys.TAB).sendKeys(value).perform();
			// element.sendKeys(value);

			ExtentFactory.getInstance().getExtent().log(Status.PASS, "The User Entered the Text" + " " + "'" + value
					+ "'" + " " + "in the" + " " + "'" + fieldName + "'" + " " + "Successfully");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"The User Haven't Entered the Text" + " " + "'" + value + "'" + " " + "in the" + " " + "'"
							+ fieldName + "'" + " " + "Successfully" + e.getMessage());
		}
	}

	/*
	 * Function Description: This function is used to Mouse Hover on specific
	 * element In the web page
	 * 
	 * @parameter fieldname, element
	 */
	public static void mouseHoveronElement(String fieldName, WebElement element) {
		try {

			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(element));

			Actions action = new Actions(DriverFactory.getInstance().getDriver());
			action.moveToElement(element).perform();

			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"The User Has Been Hovered to the" + " " + "'" + fieldName + "'" + " " + "Successfully");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "The User Hasn't Been Hovered to the" + " " + "'"
					+ fieldName + "'" + " " + "Successfully" + e.getMessage());
		}
	}

	/*
	 * Function Description: This function is used to Click the Specific Element In
	 * the Web Page using Java script executor
	 * 
	 * @parameter fieldname, element
	 */

	public static void JSclick(String fieldName, WebElement element) {
		try {

			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(2))
					.until(ExpectedConditions.elementToBeClickable(element));

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("arguments[0].click();", element);

			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"The Field" + " " + "'" + fieldName + "'" + " " + "Has Been Clicked Successfully");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "The Field" + " " + "'" + fieldName + "'" + " "
					+ "Has Not Been Clicked Successfully" + e.getMessage() + e.getMessage());
		}
	}

	/*
	 * Function Description: This function is used to Handle the Privacy popup that
	 * appears in the web page
	 * 
	 * @parameter fieldname, element
	 */
	public static void handlePrivacyPopup(WebElement privacyPopup, WebElement acceptButton) {
		try {
			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(2))
					.until(ExpectedConditions.visibilityOf(privacyPopup));

			if (privacyPopup.isDisplayed()) {
				acceptButton.click();
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						"Accept Button In the Privacy popup Has Been Clicked Successfully");
			}
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"Privacy Pop up Not Found, Continuing with the tests" + e.getMessage());

		}
	}

	/*
	 * Function Description: This function is used to Handle the wait for list of
	 * elements to be visible
	 * 
	 * @parameter element
	 */
	public static void waitForListOfElements(List<WebElement> elementsList) {
		try {
			new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfAllElements(elementsList));

			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					"The wait time has been implemented successfully until list of webelements is visible");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.INFO,
					"The wait time has not been implemented until list of webelements is visible");

		}
	}
}
