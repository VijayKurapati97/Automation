package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigProperties;

public final  class PropertyUtils {

	private PropertyUtils() {
		
	}
	
	private static Properties property =new Properties();
	
	private static final Map<String,String> CONFIGMAP =new HashMap<String, String>();
	static {
		try {
			FileInputStream File= new FileInputStream(FrameworkConstants.getConfigfilePath());
			property.load(File);
			
			
			for(Map.Entry<Object, Object> entry :property.entrySet()) {
				
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			
		//	property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String get(ConfigProperties key) throws Exception {
		
		if(Objects.isNull(key)||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("property name "+ key +"is not found please check config.properties");
		}
		
		return CONFIGMAP.get(key.name().toLowerCase());
		
	}
	
	
	
	
	
}
