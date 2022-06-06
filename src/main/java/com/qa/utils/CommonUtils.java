package com.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.factory.ExplicitWaitFactory;
import com.qa.reports.ExtentLogger;

public class CommonUtils {


	public static  void clickk(By by ,WaitStrategy waitstrategy,String eleName) {

		WebElement element=ExplicitWaitFactory.performexplicitWait(waitstrategy, by);
		element.click();
		try {
			ExtentLogger.pass(eleName+" is clicked",true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sendText(By by, String value ,WaitStrategy waitstrategy,String eleName) {

		WebElement element=ExplicitWaitFactory.performexplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value+" is Entered in "+eleName,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static boolean  isDisplayed(By by,WaitStrategy waitstrategy,String eleName) throws Exception {

		WebElement element=ExplicitWaitFactory.performexplicitWait(waitstrategy, by);
		element.isDisplayed();

		ExtentLogger.pass(eleName+" is Displayed",true);
		return false;
	}

	public static String getElementText(By by,WaitStrategy waitstrategy,String eleName) throws Exception {

		WebElement element=ExplicitWaitFactory.performexplicitWait(waitstrategy, by);
		String str=element.getText();

		ExtentLogger.pass(str+eleName+" is Displayed",true);
		return str;
	}


	public static void selectByText(By by,WaitStrategy waitstrategy,String eleName ,String visibleText) {
		WebElement element=ExplicitWaitFactory.performexplicitWait(waitstrategy, by);
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);

	}

	public static void maximizeWindow() {
		DriverManager.getDriver().manage().window().maximize();
	}

}
