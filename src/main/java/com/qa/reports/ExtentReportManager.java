package com.qa.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {
	
	private ExtentReportManager() {
		
	}

	

	public static ThreadLocal<ExtentTest> exText=new ThreadLocal();

	 static ExtentTest getExtentTest() {
		return exText.get();
	}


	 static void setExtentTest(ExtentTest test) {
		exText.set(test);
	}

	 static void unLoad() {
		exText.remove();
	}

	
}
