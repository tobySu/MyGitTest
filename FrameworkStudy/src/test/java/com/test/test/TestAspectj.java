/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.test.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yue.aspectj.ServiceAspect;
import com.yue.aspectj.UserServiceAspect;
import com.yue.entity.User;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class TestAspectj {
	
	private final static Logger log = Logger.getLogger(TestAspectj.class);

	public static void main(String[] args) {
		//启动Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取service组件
		UserServiceAspect service = (UserServiceAspect) context.getBean("userServiceAspect");
		//以普通的方式调用UserService对象的三个方法
		User user = service.get(1L);
		service.save(user);
		try {
			service.delete(1L);
		} catch (Exception e) {
			if(log.isWarnEnabled()){
				log.warn("Delete user : " + e.getMessage());
			}
		}
	}
}
