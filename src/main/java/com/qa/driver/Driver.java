package com.qa.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public final class Driver {


	private Driver() {

	}


	public static WebDriver driver;	





	public static void initDriver(String browser) throws Exception {

		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeriverPath());
				WebDriver driver= new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
				WebDriver driver= new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));

		}

	}



	public static void quitdriver() {

		if(Objects.nonNull(DriverManager.getDriver())) {

			DriverManager.getDriver().quit();	 
			DriverManager.unLoad();
		}

	}

}
