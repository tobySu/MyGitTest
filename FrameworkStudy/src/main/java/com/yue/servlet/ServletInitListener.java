/**
 * @Copyright:Copyright (c) 1991 - 2015
 * @Company: Macroview
 */
package com.yue.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

import com.yue.controller.TestController;
import com.yue.ws.WbserviceImpl;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class ServletInitListener implements ServletContextListener{
	
	public void contextDestroyed(ServletContextEvent event) {
		System.getProperties().remove("logdir");
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("tobytest==>"+ServletInitListener.class.getResource("").getPath());
		System.out.println("tobytest==>"+ServletInitListener.class.getResource("/")
					.getFile());
		System.out.println(event.getServletContext().getRealPath("/"));
		System.out.println(event.getServletContext().getRealPath(""));
		System.out.println(event.getServletContext().getContextPath());
		System.setProperty("logdir", event.getServletContext().getRealPath("/"));
		initLog4j(event.getServletContext().getRealPath("/"));
		
		/* String address = "http://192.168.11.198:8089/FrameworkStudy/Webservice";
		 //使用Endpoint类提供的publish方法发布WebService，发布时要保证使用的端口号没有被其他应用程序占用
		 Endpoint.publish(address , new WbserviceImpl());
		 System.out.println("tobytest==>发布webservice成功!");*/
	}

	private void initLog4j(String path) {
		File file = new File(path+"static//log4j2.xml");
		 try {
		     LoggerContext context =(LoggerContext)LogManager.getContext(false);
		     context.setConfigLocation(file.toURI());
		     //重新初始化Log4j2的配置上下文
		     context.reconfigure();
		   }catch(Exception e){
			   System.out.println("[SYSTEM]==> Log4j2 初始化失败，读取[log4j2]文件失败!");
		   }
	}

}
