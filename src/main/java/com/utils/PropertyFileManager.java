package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileManager {

	private static File file;
	private static FileInputStream fis;
	private static String configFilePath;
	private static Properties configProperty= new Properties();
	private static String objectRepoFilePath;
	private static Properties ORProperty= new Properties();
	
	public static void setConfigPropFilePath(String configFilePath)
	{
		PropertyFileManager.configFilePath=configFilePath;
		
	}
	public static String getConfigPropFilePath()
	{
		return configFilePath;
	}
	
	public static  void setobjectRepoFilePath(String ORFilePath)
	{
		PropertyFileManager.objectRepoFilePath=ORFilePath;
		
	}
	public static String getobjectRepoFilePath()
	{
		return objectRepoFilePath;
	}
	
	
	
	public static  Properties createConfigPropertyInstance()
	{
		try{
		file = new File(PropertyFileManager.getConfigPropFilePath());
		fis= new FileInputStream(file);
		configProperty.load(fis);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return configProperty;
	}
	

	public static  Properties createObjectRepoPropertyInstance()
	{
		try{
		file = new File(PropertyFileManager.getobjectRepoFilePath());
		fis= new FileInputStream(file);
		ORProperty.load(fis);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ORProperty;
	}
}
