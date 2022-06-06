package com.qa.constants;


import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public final class FrameworkConstants {
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/Executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output";
  	private static  String extentReportFilePath="";
	
	private static final String EXCELPATH="D:/AutomationPractice/Automation/src/test/resources/excel/testdata.xlsx";
	
	private static final String GECKODRIVERPATH= System.getProperty("user.dir")+"/src/test/resources/Executables/geckodriver.exe";

	


	

	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}


	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			try {
				extentReportFilePath=createReportPath();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return extentReportFilePath;
	}

	
	private static String createReportPath() throws Exception {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"index.html";
		}
		
	}
	
	public static String getExcelpath() {
		return EXCELPATH;
	}
	
	
	
	
	public static void setExtentReportFilePath(String extentReportFilePath) {
		FrameworkConstants.extentReportFilePath = extentReportFilePath;
	}

	private static final int EXPLICITWAIT =10;
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigfilePath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeriverPath() {
		return CHROMEDRIVERPATH;
	}

}
