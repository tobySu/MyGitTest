/**
 * @Copyright:Copyright (c) 1991 - 2015
 * @Company: Macroview
 */
package com.yue.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@Entity
@Table(name="user_core")
public class User_core{
	private Long user_id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	private String telephone;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
