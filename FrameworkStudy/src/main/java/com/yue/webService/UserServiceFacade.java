/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.webService;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@WebService  
public interface UserServiceFacade {  
  
	/**
	 * 返回javabeen必须提供service接口以及返回类型给客户端
	 * 
	 * @param name
	 * @return
	 *//*
    public @WebResult User getUserByName(@WebParam(name ="name") String name);*/  
    
    public List<String> test(String test,String test2);
    
    /**
     * 添加webParam(name可有可无)后客户端可使用xfire，但只能返回字符串（应该是基本类型）
     * 
     * @param name
     * @return
     */
    public String test2(@WebParam(name = "arg0",targetNamespace = "http://webService.yue.com/") String name,
    		@WebParam(name = "arg1",targetNamespace = "http://webService.yue.com/")String test);
    
    public String test3();
}  
