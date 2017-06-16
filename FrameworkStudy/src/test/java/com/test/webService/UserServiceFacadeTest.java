/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.test.webService;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.yue.webService.User;
import com.yue.webService.UserServiceFacade;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class UserServiceFacadeTest {
	
	//动态调用，改service不能有返回javabeen类型
	@Test
	public void test(){  
		//方法2,动态调用
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8080/FrameworkStudy/services/UserServiceFacade?wsdl");
        // url为调用webService的wsdl地址
        String xmlStr = "张三";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke("test", xmlStr,"toby");
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
	
	@Test
	public void testJson(){  
		//方法2,动态调用
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8080/FrameworkStudy/services/UserServiceFacade?wsdl");
        // url为调用webService的wsdl地址
        String xmlStr = "张三";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke("test2", xmlStr,"王五");
            System.out.println(objects[0].toString());
            List<User> us = JSONObject.parseArray(objects[0].toString(),User.class);
            System.out.println(us.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	//需要有服务器提供service接口，以及返回实体类
	@Test
	public void test2() throws Exception, SecurityException{
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
		  
        factory.setServiceClass(UserServiceFacade.class);  
  
        factory.setAddress("http://localhost:8080/FrameworkStudy/services/UserServiceFacade?wsdl");  
  
          
  
       UserServiceFacade service = (UserServiceFacade) factory.create();  
          
  
        System.out.println("#############Client getUserByName##############");  
  
        User user = service.getUserByName("张三");  
  
        System.out.println(user);  
	}
	
	@Test
	public void test3(){  
		//方法2,动态调用
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8080/FrameworkStudy/services/UserServiceFacade?wsdl");
        // url为调用webService的wsdl地址
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke("test3");
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
