package com.qa.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer{

	private int count=0;
	private int retries =1;
	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
				
			 value =count<retries;
			
			count++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
