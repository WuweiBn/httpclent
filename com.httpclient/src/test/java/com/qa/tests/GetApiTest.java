package com.qa.tests;

import java.io.IOException;

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
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;

public class GetApiTest extends TestBase {

	TestBase testBase;
	String host;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;

	final static Logger Log = Logger.getLogger(GetApiTest.class);

	@BeforeClass
	public void setUp() {
		testBase = new TestBase();
		host = prop.getProperty("HOST");
		url = host + "/api/users?page=2";

	}

	@Test
	public void getAPITest() throws ClientProtocolException, IOException {

		Log.info("开始执行用例...");
		restClient = new RestClient();
		closeableHttpResponse = restClient.get(url);

		// 断言状态码是不是200
		Log.info("测试响应状态码是否是200");
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200, "response status code is not 200");

		// 把响应内容储存到字符串中
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

		// 创建json对象，把上面的字符串转换成json格式
		JSONObject responseJson = JSON.parseObject(responseString);

		// json内容解析
		String s = TestUtil.getValueByJPath(responseJson, "data[0]/first_name");
		Log.info("执行JSON解析，解析的内容是 " + s);
//			String s1 = TestUtil.getValueByJPath(responseJson, "data[1]/email");

		System.out.println(s);
		Log.info("接口内容响应断言");
		Assert.assertEquals(s, "Eve", "fast_name is not Eve");
//			System.out.println(s1);
		Log.info("用例执行结束...");
	}

}
