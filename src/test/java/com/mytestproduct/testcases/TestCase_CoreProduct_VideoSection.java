package com.mytestproduct.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.CoreProductFeaturePage;
import com.mytestproduct.pages.CoreProductHomePage;
import com.mytestproduct.reports.ExtentFactory;
import com.mytestproduct.utilities.ReadJson;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class TestCase_CoreProduct_VideoSection extends BaseTest {
	CoreProductHomePage home;
	CoreProductFeaturePage feature;

	@BeforeMethod
	@Parameters("appURL")
	public void loadApplication(String appURL) {
		launchApplication(appURL);
	}

	@Test
	public void VerifyVideoSectionInNewsAndFeaturesPage() throws InterruptedException {
		home = new CoreProductHomePage(DriverFactory.getInstance().getDriver());
		feature = new CoreProductFeaturePage(DriverFactory.getInstance().getDriver());
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"START : <---------------- CoreProduct_News And Features Page_Verify Video Section ---------------->");
		home.verifyPageTitle(ReadJson.readJSONValue("cpHomePageTitle"));
		home.verifyTicketAccessPopUp();
		home.navigateToNewsAndFeaturesSubMenu();
		feature.scrollToVideosSection();
		feature.getVideoSectioncount(ReadJson.readJSONValue("cpExpectedVideosCount"));
		feature.getVideoDaysCountGreaterThan3Days(ReadJson.readJSONValue("cpVideosDayCount"));
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"END : <---------------- CoreProduct_News And Features Page_Verify Video Section ---------------->");

	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().unload();
	}

}
