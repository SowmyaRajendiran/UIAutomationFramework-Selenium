package com.mytestproduct.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.CoreProductFeaturePage;
import com.mytestproduct.pages.CoreProductHomePage;
import com.mytestproduct.utilities.ReadJson;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class CP_VideoSectionTestCase extends BaseTest {
	CoreProductHomePage home;
	CoreProductFeaturePage feature;

	@BeforeMethod
	public void launchApplication() {
		launchApplication("cpurl");
	}

	@Test
	public void VerifyVideoSectionInNewsAndFeaturesPage() throws InterruptedException {
		home = new CoreProductHomePage(DriverFactory.getInstance().getDriver());
		feature = new CoreProductFeaturePage(DriverFactory.getInstance().getDriver());
		home.verifyTicketAccessPopUp();
		home.navigateToNewsAndFeaturesSubMenu();
		feature.scrollToVideosSection();
		feature.getVideoSectioncount();
		feature.getVideoDaysCountGreaterThan3Days(ReadJson.readJSONValue("daysCount"));

	}

}
