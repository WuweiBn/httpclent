package com.qa.restclient;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RestClient {

	// get请求方法
	public void get1(String url) throws ClientProtocolException, IOException {

		// 创建一个可以关闭的httpclient请求
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建一个httpGet请求
		HttpGet httpget = new HttpGet(url);

		// 执行请求，相当于psotman点击发送按钮，然后赋值给httpResponse对象接收
		CloseableHttpResponse httpResponse = httpclient.execute(httpget);

		// 拿到http状态的响应码
		int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("response status code -->" + responseStatusCode);

		// 把响应内容存在字符串对象
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

		// 创建json对象，把上面字符串转化为json对象
		JSONObject responseJson = JSON.parseObject(responseString);
		System.out.println("respon json from api --->" + responseJson);

		// 获取响应头信息，返回一个数组
		Header[] headersArray = httpResponse.getAllHeaders();

		// 创建一个hashmap对象通过pastman可以看到请求响应头信息都是key和value的形式，所以用hashmap
		HashMap<String, String> hm = new HashMap<String, String>();

		// 使用增强for循环遍历headerArray数组，依次把元素添加到hashmap集合
		for (Header header : headersArray) {
			hm.put(header.getName(), header.getValue());
		}

		System.out.println("response headers -->" + hm);

	}

	final static Logger Log = Logger.getLogger(RestClient.class);

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		// 创建一个可以关闭的httpclient请求
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建一个HttpGet的请求对象
		HttpGet httpget = new HttpGet(url);

		Log.info("开始发送get请求·····");

		// 执行请求，相当于psotman点击发送按钮，然后赋值给httpResponse对象接收
		CloseableHttpResponse httpResponse = httpclient.execute(httpget);

		Log.info("发送请求成功！开始得到响应对象。");

		return httpResponse;
	}

	// get带请求头
	public CloseableHttpResponse get(String url, HashMap<String, String> headermap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet httpget = new HttpGet(url);

		for (Map.Entry<String, String> entry : headermap.entrySet()) {

			httpget.addHeader(entry.getKey(), entry.getValue());
		}

		CloseableHttpResponse httpResponse = httpclient.execute(httpget);

		Log.info("开始发送带请求头的get请求...");

		return httpResponse;

	}

//	final static Logger Log = Logger.getLogger(RestClient.class);

// psot  方法
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headermap)
			throws ClientProtocolException, IOException {

		// 创建一个可以关闭的httpclient
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建一个post请求
		HttpPost httppost = new HttpPost(url);

		// 设置payloa
		httppost.setEntity(new StringEntity(entityString));

		// 加载请求头到httppost对象
		for (Map.Entry<String, String> entry : headermap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}

		// 发送post请求
		CloseableHttpResponse httpResponse = httpclient.execute(httppost);

		Log.info("开始发送post请求");

		System.out.println();

		return httpResponse;

	}

	/**
	 * 获取响应状态码，常用来和TestBase中定义的状态码常量去测试断言使用
	 * 
	 * @param response
	 * @return 返回int类型状态码
	 */
	public int getStatusCode(CloseableHttpResponse response) {

		int statusCode = response.getStatusLine().getStatusCode();
		Log.info("解析，得到响应状态码:" + statusCode);
		return statusCode;
	}

	/**
	 * 
	 * @param response, 任何请求返回返回的响应对象 
	 * @return， 返回响应体的json格式对象，方便接下来对JSON对象内容解析
	 *        		接下来，一般会继续调用TestUtil类下的json解析方法得到某一个json对象的值
	 * @throws ParseException
	 * @throws IOException
	 */
	public JSONObject getResponseJson(CloseableHttpResponse response) throws ParseException, IOException {
		Log.info("得到响应对象的String格式");
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject responseJson = JSON.parseObject(responseString);
		Log.info("返回响应内容的JSON格式");
		return responseJson;
	}

}