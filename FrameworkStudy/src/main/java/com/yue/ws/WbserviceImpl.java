/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.ws;

import javax.jws.WebService;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@WebService
public class WbserviceImpl implements WbService{

	@Override
	public String tobytest(String str) {
		System.out.println("tobytest==>传过来的参数str：" +str);
		return "tobytest==>str : "+str;
	}

}
