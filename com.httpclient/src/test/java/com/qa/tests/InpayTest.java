package com.qa.tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.data.Msg;
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;

public class InpayTest extends TestBase {
	
	TestBase testbase;
	String host;
	String url ;
	RestClient restClient ;
	CloseableHttpResponse  closeableHttpResponse ;
	
	final static Logger Log = Logger.getLogger(InpayTest.class);
	
	@BeforeClass
	public void setUp() {
		testbase = new TestBase();
		host = prop.getProperty("HOST");
		url = host + "/process/topic/manager";
		
	}	
		@Test
		public  void  inpayApiTest() throws ClientProtocolException, IOException, ParseException {
			
			Log.info("开始执行用例...");
			restClient = new RestClient();
			//准备请求头信息
			HashMap<String,String> headermap = new HashMap<String,String>();
			headermap.put("Content-Type", "application/json"); //这个在postman中可以查询到
			
			int[] app = {1590225684,1234676757};
			
			Msg msg = new Msg(app,"into_after_loan",3);
			String userJsonString = JSON.toJSONString(msg);
			
			closeableHttpResponse = restClient.post(url, userJsonString, headermap);
				
			Log.info("测试响应状态码是否是200");
			int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200,"status code is not 200");
			
			JSONObject responseJson = restClient.getResponseJson(closeableHttpResponse);
			System.out.println("respon json from API-->" + responseJson);

//			String s = TestUtil.getValueByJPath(responseJson, "data[0]/first_name");
//			Log.debug(s);
//			System.out.println(s);
			
		}
		
}