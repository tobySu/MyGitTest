/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.test.test;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.beanutils.ConvertUtils;





/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class TestJava {

	public static void main(String[] args) throws Exception {
		ConcurrentHashMap<String, Object> m = new ConcurrentHashMap<String, Object>();
		m.put("1", 1);
		m.put("2", 2);
		System.out.println(m.size());
		System.out.println("this is git test code ...");
	}
}
