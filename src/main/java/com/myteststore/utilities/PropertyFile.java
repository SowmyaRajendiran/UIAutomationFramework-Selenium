package com.myteststore.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class PropertyFile {

	static Properties property = new Properties();

	/*
	 * Function Description: Method to read the properties from the config.properties file
	 * 
	 * @param key
	 */
	public static String getPropertyValue(String key) {

		String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propertyFilePath);
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String value = property.get(key).toString();

		if (StringUtils.isEmpty(value)) {
			try {
				throw new Exception("Value is not specified for key: " + key + " in properties file.");
			} catch (Exception e) {
			}
		}

		return value;
	}
	
	
}
