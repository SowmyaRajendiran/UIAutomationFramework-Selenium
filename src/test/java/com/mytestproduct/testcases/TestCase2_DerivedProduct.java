package com.mytestproduct.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mytestproduct.base.BaseTest;
import com.mytestproduct.base.DriverFactory;
import com.mytestproduct.pages.DerivedProductPage;

@Listeners(com.mytestproduct.utilities.Listeners.class)
public class TestCase2_DerivedProduct extends BaseTest {
	
	DerivedProductPage derivedpage; 

	@BeforeMethod
	public void launchApplication() {
		launchApplication("dp2url");
	}

	@Test
	public void test1() throws InterruptedException, IOException {
		derivedpage = new DerivedProductPage(DriverFactory.getInstance().getDriver());
		derivedpage.verifyLinks();
		Thread.sleep(2000);

	}

}
