package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.data.Users;
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;

public class PostAPITest extends TestBase {
		
	TestBase testbase;
	String host;
	String url ;
	RestClient restClient ;
	CloseableHttpResponse  closeableHttpResponse ;
	
	final static Logger Log = Logger.getLogger(PostAPITest.class);
	
	@BeforeClass
	public void setUp() {
		testbase = new TestBase();
		host = prop.getProperty("HOST");
		url = host + "/api/users"; 
	}
										
	@Test
	public void postApiTest() throws ClientProtocolException, IOException {
		Log.info("开始执行用例...");
		restClient = new RestClient();
		//准备请求头信息
		HashMap<String,String> headermap = new HashMap<String,String>();
		headermap.put("Content-Type", "application/json"); //这个在postman中可以查询到
		
		//对象转换成Json字符串
		Users user = new Users("Anthony","tester");
		String userJsonString = JSON.toJSONString(user);
		//System.out.println(userJsonString);
		
		closeableHttpResponse = restClient.post(url, userJsonString, headermap);
		
		//验证状态码是不是200
		Log.info("测试响应状态码是否是200");
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200,"status code is not 201");
		
		//断言响应json内容中name和job是不是期待结果
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		JSONObject responseJson = JSON.parseObject(responseString);
		//System.out.println(responseString);
		String name = TestUtil.getValueByJPath(responseJson, "name");
		String job = TestUtil.getValueByJPath(responseJson, "job");
		System.out.println(name);
		Assert.assertEquals(name, "Anthony","name is not same");
		Assert.assertEquals(job, "tester","job is not same");

	}
}
