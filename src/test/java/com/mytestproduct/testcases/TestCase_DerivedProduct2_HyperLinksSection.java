package com.mytestproduct.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.CoreProductHomePage;
import com.mytestproduct.pages.DerivedProductPage;
import com.mytestproduct.utilities.ReadJson;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class TestCase_DerivedProduct2_HyperLinksSection extends BaseTest {

	DerivedProductPage derivedpage;

	@BeforeMethod
	public void launchApplication() {
		launchApplication("dp2url");
	}

	@Test
	public void VerifyHyperLinksInFooterSection() throws InterruptedException, IOException {

		derivedpage = new DerivedProductPage(DriverFactory.getInstance().getDriver());
		derivedpage.verifyPageTitle(ReadJson.readJSONValue("dp2HomePageTitle"));
		derivedpage.navigateToFooterSection();
		derivedpage.verifyHyperLinksInFooterSectionAndStoreItInCSV(ReadJson.readJSONValue("dp2HyperLinksCount"));
		derivedpage.verifyDuplicateHyperLinksInFooterSection();

	}

}
