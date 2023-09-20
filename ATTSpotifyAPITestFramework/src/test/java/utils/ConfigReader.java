package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String readConfig(String key) throws IOException 
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		
		File load = new File(path);
		
		FileInputStream file = new FileInputStream(load);
		
		Properties prop = new Properties();
		
		prop.load(file);
		
		//From above 4 steps will get the data from config file.
		//and to read the data will follow below steps:
//		String nameValue = prop.getProperty("name");
//		System.out.println(nameValue);
		
		//But, we need to call the value as per requirement 
		//So, will pass the argument "key" and will read the same with .getProperty() which will return a value of key in form of String. refer below step:
		String value = prop.getProperty(key);
		
		return value;
	}

}
