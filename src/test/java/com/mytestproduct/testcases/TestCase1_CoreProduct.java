package com.mytestproduct.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.CoreProductFeaturePage;
import com.mytestproduct.pages.CoreProductHomePage;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class TestCase1_CoreProduct extends BaseTest {
	CoreProductHomePage home;
	CoreProductFeaturePage feature; 

	@BeforeMethod
	public void launchApplication() {
		launchApplication("cpurl");
	}

	@Test
	public void test1() throws InterruptedException {
		home = new CoreProductHomePage(DriverFactory.getInstance().getDriver());
		feature = new CoreProductFeaturePage(DriverFactory.getInstance().getDriver());
		home.closeTicketAccessPopUp();
		feature.scrollToVideosSection();
		feature.getVideoSectioncount();
		feature.getVideoDayscount();

	}

}
