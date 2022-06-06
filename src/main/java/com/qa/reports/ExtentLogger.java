package com.qa.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.driver.DriverManager;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;
import com.qa.utils.ScreenShotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message );
	}
	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message );
	}
	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message );
	}

	
	
	public static void pass(String message,boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") &&
			isScreenShotNeeded	) {
			
			ExtentReportManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}else {
			pass(message);
		}
		
		
	}
	
	public static void fail(String message,boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") &&
			isScreenShotNeeded	) {
			
			ExtentReportManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}else {
			fail(message);
		}
		
	}
	
	
	public static void skipped(String message,boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") &&
			isScreenShotNeeded	) {
			
			ExtentReportManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}else {
			skip(message);
		}
		
		
	}
	
	
	
}
