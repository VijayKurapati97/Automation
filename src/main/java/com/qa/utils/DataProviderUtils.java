package com.qa.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	private static List<Map<String, String>> list=new ArrayList<>();
	@DataProvider
	public static Object[] getData(Method m) {
		
		String testname=m.getName();
		if(list.isEmpty()) {
			
			 list=ExcelUtils.getTetsDetails("LOGINDATA");
			
			
		
		}
		List<Map<String, String>> slist=new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
		
			if(list.get(i).get("testName").equalsIgnoreCase(testname)) {
				
				slist.add(list.get(i));
			}
		
		}
		return slist.toArray();
	}
	
	
	
	
	
	
}
