package com.mytestproduct.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.CoreProductHomePage;
import com.mytestproduct.pages.DerivedProductPage;
import com.mytestproduct.reports.ExtentFactory;
import com.mytestproduct.utilities.ReadJson;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class TestCase_DerivedProduct2_HyperLinksSection extends BaseTest {
	CoreProductHomePage home;
	DerivedProductPage derivedpage;

	@BeforeMethod
	@Parameters({ "appURL", "browser" })
	public void loadApplication(String appURL, String browser) {
		launchApplication(appURL,browser);
	}


	@Test
	public void VerifyHyperLinksInFooterSection() throws InterruptedException, IOException {
		home = new CoreProductHomePage(DriverFactory.getInstance().getDriver());
		derivedpage = new DerivedProductPage(DriverFactory.getInstance().getDriver());
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"START : <---------------- DerivedProduct2_HyperLinkVerification ---------------->");
		home.verifyPageTitle(ReadJson.readJSONValue("dp2HomePageTitle"));
		home.verifyPrivacyPopUp();
		derivedpage.navigateToFooterSection();
		derivedpage.verifyHyperLinksInFooterSectionAndStoreItInCSV(ReadJson.readJSONValue("dp2HyperLinksCount"));
		derivedpage.verifyDuplicateHyperLinksInFooterSection();
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"END : <---------------- DerivedProduct2_HyperLinkVerification ---------------->");
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().unload();
	}

}
