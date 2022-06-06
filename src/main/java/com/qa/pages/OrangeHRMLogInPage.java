package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentReport;
import com.qa.reports.ExtentReportManager;
import com.qa.utils.CommonUtils;

public final class OrangeHRMLogInPage  {



	private final By textboxUsername = By.id("txtUsername");
	private final By textBoxPassword = By.xpath("//input[@id='txtPassword']");
	private final By buttonLogin =By.xpath("//input[@id='btnLogin']");
	private final By ErrorMessage=By.xpath("//*[@id='spanMessage']");


	public OrangeHRMLogInPage enterUserName(String username) {


	CommonUtils.sendText(textboxUsername,username, WaitStrategy.PRESENCE,"userName");
		return this;
	}


	public OrangeHRMLogInPage enterPassword(String password ) {

		CommonUtils.sendText(textBoxPassword,password, WaitStrategy.PRESENCE,"password");

		return this;


	}


	public OrangeHRMDashboardPage clickLogIn() {

		CommonUtils.clickk(buttonLogin, WaitStrategy.CLICKABLE,"login button");

		return new OrangeHRMDashboardPage();

	}
	
	
public boolean errorDisplay()  {

	try {
		CommonUtils.isDisplayed(ErrorMessage,WaitStrategy.VISIBLE,"Error Message" );
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
	
	
	
}

public String PrintError()  {
	String errortext = null;
	try {
		errortext =  CommonUtils.getElementText(ErrorMessage,WaitStrategy.VISIBLE , " Error ");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return errortext;
}

}
