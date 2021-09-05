package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\AutomationFIles\\vtigerData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
//	public String getDataFromExcel() {
//		return null;
//	}
}
