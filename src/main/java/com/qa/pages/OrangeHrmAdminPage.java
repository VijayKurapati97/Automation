package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;
import com.qa.utils.CommonUtils;

public class OrangeHrmAdminPage {


	private final By textBoxUsername=By.xpath("//*[@id='searchSystemUser_userName']");
	private final By userRoleDropdown=By.xpath("//*[@id='searchSystemUser_userType']");
	private final By textBoxEmpName=By.xpath("//*[@id='searchSystemUser_employeeName_empName']");
	private final By statusDropdown=By.xpath("//*[@id='searchSystemUser_status']");
	private final By searchBtn=By.id("searchBtn");
	private final By noRecords=By.xpath("//*[text()='No Records Found']");


	public OrangeHrmAdminPage enterEmplyeeUserName(String userName) {

		CommonUtils.sendText(textBoxUsername, userName, WaitStrategy.PRESENCE, "Username");
		return this;

	}
	public OrangeHrmAdminPage enterRole() {

		CommonUtils.selectByText(userRoleDropdown, WaitStrategy.CLICKABLE, "roledropdown", "ESS");
		return this;

	}
	public OrangeHrmAdminPage enterEmployeeName(String userName) {

		CommonUtils.sendText(textBoxEmpName, userName, WaitStrategy.PRESENCE, "Username");
		return this;

	}
	public OrangeHrmAdminPage enterStatus() {

		CommonUtils.selectByText(statusDropdown, WaitStrategy.CLICKABLE, "UserStatus", "Enabled");
		return this;

	}
	public OrangeHrmAdminPage clickSearch() {
		CommonUtils.clickk(searchBtn,  WaitStrategy.CLICKABLE, "searchButton");
		return this;
	}
	
	public String getNoRecordFoundtext() {
		
		String text=null;
		try {
			 text=CommonUtils.getElementText(noRecords, WaitStrategy.VISIBLE , "noRecordsFound");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return text;
	}
}