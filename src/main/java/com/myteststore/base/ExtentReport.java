package com.myteststore.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myteststore.utilities.PropertyFile;

public class ExtentReport {

	static ExtentReports extent;

	/*
	 * Function Description: Method to setup Extent Report
	 */
	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + actualDate + ".html";

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		extent = new ExtentReports();
		extent.attachReporter(sparkReport);

		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");

		extent.setSystemInfo("Executed on Environment: ", PropertyFile.getPropertyValue("url"));
		extent.setSystemInfo("Executed on Browser: ", PropertyFile.getPropertyValue("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

		return extent;
	}
}
