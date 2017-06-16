/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.entity.User_core;
import com.yue.repository.User_coreDao;

/**
 * @author Toby
 * @since: v1.0
 */
@Controller
public class TestController2 {
	
	@Autowired
	private User_coreDao user_coreDao;

	@ResponseBody
	@RequestMapping(value = "/c2test", method = RequestMethod.GET)
	public String test() {
		System.out.println("tobytest==>enter c2test");
		String o = httpGet("http://172.22.251.116/merakiTest/demo/test/udpTest?url=n165.meraki.com&udp=3799");
		if (o == null) {
			System.out.println("o is null");
		}
		else {
			System.out.println("tobytest==>" + o);
		}
		return o;
	}

	public static String httpGet(String url) {
		// get请求返回结果
		String result = null;
		try {
			// DefaultHttpClient client = new DefaultHttpClient();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			HttpResponse response = HttpClients.createDefault().execute(request);
			// HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				result = EntityUtils.toString(response.getEntity(), "utf-8");
				/** 把json字符串转换成json对象 **/
				// url = URLDecoder.decode(url, "UTF-8");
			}
			else {
				System.out.println("get请求提交失败:" + url);
			}
		}
		catch (Exception e) {
			System.out.println("get请求提交失败:" + url + e);
		}
		return result;
	}

	public void test2() {

	}

	@ResponseBody
	@RequestMapping(value = "/testgf", method = RequestMethod.GET)
	public String testgf(){
		/*Iterable<User_core> us = user_coreDao.findAll();
		for(User_core c : us){
			if(c.getUser_id()==2126){
				System.out.println(c.getTelephone());
				System.out.println(c.getTelephone().indexOf("-"));
			}
		}*/
		List<User_core> ucs = user_coreDao.findlike("%-%-%");
		Set<String> sets = new HashSet<String>();
		for(User_core uc : ucs){
			sets.add(uc.getTelephone().substring(uc.getTelephone().indexOf("-")+1,uc.getTelephone().lastIndexOf("-")));
		}
		for(String str : sets){
			if(str.length()>5){
			System.out.println("update dbo.user_core set telephone=replace(telephone,'"+str+"-','"+str+"#');");
			}
		}
		return "sucess and size = " +ucs.size();
		
		
	}
	
	public static void main(String[] args) {
		/*String test = "020-87555888-6060";
		String t = test.replaceAll("87555888-", "87555888#");
		System.out.println(t);
		String t2 = t.replaceAll("-", "");
		System.out.println(t2);
		System.out.println(t2.replaceAll(" -", ""));*/
		/*String str = "020-87555888-6060";
		String newStr = str.replaceAll("[-+()]","#");  //\\b*-\\b
		System.out.println(newStr);*/
		String test  ="020-87555888-6060";
		System.out.println(test.substring(test.indexOf("-")+1,test.lastIndexOf("-")));
	}
}
