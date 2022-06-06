package com.qa.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.constants.FrameworkConstants;

public final class ExtentReport {

	ExtentReport(){
	}
	
	private static ExtentReports extent;
	
	public static void initReports() throws Exception {
		if(Objects.isNull(extent)) {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation reports");
		spark.config().setReportName("reportings");
		}	
	}
	
	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		ExtentReportManager.unLoad();
		Desktop.getDesktop().browse (new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		
	}
	
	public static void createTest(String testcasename) {
		
		ExtentTest test=extent.createTest(testcasename);
		ExtentReportManager.setExtentTest(test);
	}
	
	
	
	
}
