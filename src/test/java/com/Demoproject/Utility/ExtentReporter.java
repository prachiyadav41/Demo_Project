package com.Demoproject.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports extent;
	public static ExtentReports initializeReporter() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/extentreport.html");
		reporter.config().setDocumentTitle("Customized-Report");
		reporter.config().setReportName("SearchReport");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Company Name", "Infosys");
		extent.setSystemInfo("Project Name", "abc");
		extent.setSystemInfo("Tester Name", "Prachi yadav");
		return extent;
	}




}
