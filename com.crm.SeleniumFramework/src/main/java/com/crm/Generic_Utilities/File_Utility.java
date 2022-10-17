package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to launch the application
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author PAVAN
	 */
	public String getPropertyKeyValue(String key) throws Throwable{
		FileInputStream fiu = new FileInputStream("./CommonProperties.properties");
		Properties pro = new Properties();
		pro.load(fiu);
		String Value = pro.getProperty(key);
		return Value;
	}
}
