package com.mytestproduct.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.DerivedProductPage;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class DP2_HyperLinksTestCase extends BaseTest {

	DerivedProductPage derivedpage;

	@BeforeMethod
	public void launchApplication() {
		launchApplication("dp2url");
	}

	@Test
	public void VerifyHyperLinksInFooterSection() throws InterruptedException, IOException {
		derivedpage = new DerivedProductPage(DriverFactory.getInstance().getDriver());
		derivedpage.navigateToFooterSection();
		derivedpage.verifyHyperLinksInFooterSectionAndStoreItInCSV();
		derivedpage.verifyDuplicateHyperLinksInFooterSection();

	}

}
