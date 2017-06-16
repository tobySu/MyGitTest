/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.aspectj;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.yue.entity.User;

/**
 * 用户服务模型
 */
@Component
public class UserServiceAspect {

	private final static Logger log = Logger.getLogger(UserServiceAspect.class);
	
	public User get(long id){
			System.out.println("getUser method . . .");
		return new User();
	}
	
	public void save(User user){
		System.out.println("saveUser method . . .");
	}
	
	public boolean delete(long id) throws Exception{
		if(true){
			System.out.println("delete method . . .");
			throw new Exception("spring aop ThrowAdvice演示");
		}
		return false;
	}
	
}
