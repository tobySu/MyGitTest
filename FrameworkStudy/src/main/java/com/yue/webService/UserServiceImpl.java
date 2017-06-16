/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.webService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.alibaba.fastjson.JSONObject;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@WebService(endpointInterface = "com.yue.webService.UserServiceFacade")
/*@SOAPBinding(style=Style.RPC)*/
public class UserServiceImpl implements UserServiceFacade {  
  
    private static Map<String,User> users = null;  
      
    private static void init(){  
        users = new HashMap<String,User>();  
        users.put("张三", new User(1,"张三","上海浦东","zs@163.com"));  
        users.put("李斯", new User(2,"李斯","上海浦东","ls@163.com"));  
        users.put("王五", new User(3,"王五","上海浦东","ww@163.com"));  
    }  
      
    /**
	 * 返回javabeen必须提供service接口以及返回类型给客户端
	 * 
	 * @param name
	 * @return
	 *//*
    @Override  
    public User getUserByName(String name) {  
        if(users == null){  
            init();  
        }  
        return users.get(name);  
    } */ 
  
	@Override
	public List<String> test(String test,String test2) {
		//return "result:"+test;
		List<String> result = new ArrayList<String>();
		result.add(test);
		result.add(test2);
		result.add("test2");
		return result;
	}

	@Override
	public String test2(String name,String test) {
		if(users == null){  
            init();  
        }  
		User u = users.get(name);
		User u2 = users.get(test);
		List<User> us = new ArrayList<User>();
		us.add(u);
		us.add(u2);
        return JSONObject.toJSONString(us); 
	}

	@Override
	public String test3() {
		return "this is test3";
	}  
  
}  
