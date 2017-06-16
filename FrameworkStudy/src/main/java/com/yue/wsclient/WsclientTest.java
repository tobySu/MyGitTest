/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.wsclient;
/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class WsclientTest {

	 public static void main(String[] args) {
		//创建一个用于产生WebServiceImpl实例的工厂，WebServiceImplService类是wsimport工具生成的
		 WbserviceImplService factory = new WbserviceImplService();
		//通过工厂生成一个WebServiceImpl实例，WebServiceImpl是wsimport工具生成的
		 WbserviceImpl wsImpl = factory.getWbserviceImplPort();
		String resResult = wsImpl.tobytest("testsuccess");
		System.out.println("调用WebService的tobytest方法返回的结果是："+resResult);
		System.out.println("---------------------------------------------------");
		 }
}
