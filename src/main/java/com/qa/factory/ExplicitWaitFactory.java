package com.qa.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constants.FrameworkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performexplicitWait(WaitStrategy waitstrategy, By by) {
		
		WebElement element=null;
		if(waitstrategy == WaitStrategy.CLICKABLE) {
			
			WebDriverWait wait =new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwait());
			element=wait.until(ExpectedConditions.elementToBeClickable(by));
			
		}else if(waitstrategy==WaitStrategy.PRESENCE) {
			
			WebDriverWait wait =new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwait());
			element=wait.until(ExpectedConditions.presenceOfElementLocated(by));
			
			
		}else if(waitstrategy==WaitStrategy.VISIBLE) {
			
			WebDriverWait wait =new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitwait());
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			
		}else if(waitstrategy==WaitStrategy.NONE) {
			
			element=DriverManager.getDriver().findElement(by);
		}
		
		return element;
		
	}
	
	
}
