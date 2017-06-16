/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@WebService
public interface WbService {

	@WebMethod
	String tobytest(String str);
}
