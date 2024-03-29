package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;

/*
 *  读取配置文件
 * 
 * */
public class TestBase {

	public Properties prop;
	
	public int  RESPNSE_STATUS_CODE_200 = 200;
	public int  RESPNSE_STATUS_CODE_201 = 201;
	public int  RESPNSE_STATUS_CODE_404 = 404;
	public int  RESPNSE_STATUS_CODE_500 = 500;
	
	final Logger Log = Logger.getLogger(TestBase.class);
	
	// 构造函数
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			prop.load(fis);
			Log.info("正在读取配置文件...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Log.error("配置文件没有找到");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
