/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.test.redis;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class TestCla {
	
	private BlockingQueue<String> q = null;
	
	@Before
	public void before(){
		q = new LinkedBlockingDeque<String>(2);
	}

	@Test
	public void test(){
		//BlockingQueue<String> q = new ArrayBlockingQueue<String>(2);
		//BlockingQueue<String> q = new LinkedBlockingDeque<String>(2);
		try {
			q.put("1");
			System.out.println("q size is "+q.size());
			q.put("2");
			System.out.println("q size is "+q.size());
			System.out.println(q.take());
			System.out.println("q size is "+q.size());
			System.out.println(q.take());
			System.out.println("q size is "+q.size());
			System.out.println(q.take());
			System.out.println("q size is "+q.size());
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void test2() throws Exception{
		//BlockingQueue<String> q = new LinkedBlockingDeque<String>(2);
		q.put("1");
		q.put("2");
		boolean b = q.offer("test", 5l, TimeUnit.SECONDS);
		System.out.println(b);
	}
}
