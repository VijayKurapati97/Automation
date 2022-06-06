package com.qa.tests;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.pages.OrangeHRMDashboardPage;
import com.qa.pages.OrangeHRMLogInPage;
import com.qa.utils.CommonUtils;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}


	@Test
	public void LogInTest1(Map<String,String> data) throws Exception {

		CommonUtils.maximizeWindow();

		OrangeHRMLogInPage ohrml=new OrangeHRMLogInPage();
		OrangeHRMDashboardPage ohrmd =new OrangeHRMDashboardPage();
		ohrml.enterUserName(data.get("userName")).enterPassword(data.get("password")).clickLogIn();

		boolean value=ohrmd.welcomeDisplayed();

		assertTrue(value);

		


	}
	@Test
	public void LogInTest2(Map<String,String> data) throws Exception {

		CommonUtils.maximizeWindow();
		OrangeHRMLogInPage ohrml=new OrangeHRMLogInPage();
		ohrml.enterUserName(data.get("userName")).enterPassword(data.get("password")).clickLogIn();
		
		boolean value=ohrml.errorDisplay();
		ohrml.PrintError();
		assertTrue(value);
		
	}

	@Test
	public void LogInLogOutTest(Map<String,String> data) {

		CommonUtils.maximizeWindow();
		OrangeHRMLogInPage ohrml=new OrangeHRMLogInPage();
		ohrml.enterUserName(data.get("userName")).enterPassword(data.get("password")).clickLogIn().clickWelcome().clickLogOut();
		String title=CommonUtils.getPageTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}

	@Test
	public void searchUser(Map<String,String> data) {
		CommonUtils.maximizeWindow();
		OrangeHRMLogInPage ohrml=new OrangeHRMLogInPage();
		ohrml.enterUserName(data.get("userName")).enterPassword(data.get("password")).clickLogIn();
		OrangeHRMDashboardPage oh=new OrangeHRMDashboardPage();
	String text=	oh.clickAdmin().enterEmplyeeUserName(data.get("employeeUserName")).enterRole().enterEmployeeName(data.get("employeeName")).enterStatus().clickSearch().getNoRecordFoundtext();
Assertions.assertThat(text).isEqualToIgnoringCase("No Records Found");

	}

}


