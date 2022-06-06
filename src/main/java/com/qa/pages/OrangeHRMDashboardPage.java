package com.qa.pages;


import java.nio.file.spi.FileSystemProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentReport;
import com.qa.reports.ExtentReportManager;
import com.qa.utils.CommonUtils;

public class OrangeHRMDashboardPage {

	private final By AdminBtn=By.id("menu_admin_viewAdminModule");
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//*[text()='Logout']");

	public OrangeHRMDashboardPage clickWelcome() {

		CommonUtils.clickk(linkWelcome, WaitStrategy.CLICKABLE,"welcome Link");
		
		
		return this;
	}

	public OrangeHRMLogInPage clickLogOut() {


		CommonUtils.clickk(linkLogout, WaitStrategy.CLICKABLE,"logOut Button");
		
		return new OrangeHRMLogInPage();

	}

public OrangeHrmAdminPage clickAdmin() {
		
		CommonUtils.clickk(AdminBtn, WaitStrategy.CLICKABLE, "admin btn");
		return new OrangeHrmAdminPage();
	}
public boolean welcomeDisplayed() {
	boolean value=false;
	try {
		 value= CommonUtils.isDisplayed(linkWelcome,WaitStrategy.VISIBLE , "welcome link");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return value;
	
	
}

}
