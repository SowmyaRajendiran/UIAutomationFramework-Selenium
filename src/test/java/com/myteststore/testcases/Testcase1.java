package com.myteststore.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.myteststore.base.BaseTest;
import com.myteststore.base.DriverFactory;
import com.myteststore.pages.HomePage;


@Listeners(com.myteststore.utilities.Listeners.class)
public class Testcase1 extends BaseTest {
	
	
	@Test
	public void test2() throws InterruptedException {
	HomePage home=new HomePage(DriverFactory.getInstance().getDriver());
	home.blog();
	Thread.sleep(2000);
	}



}
