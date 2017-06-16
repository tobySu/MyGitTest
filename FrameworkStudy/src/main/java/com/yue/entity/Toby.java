/**
 * @Copyright:Copyright (c) 1991 - 2015
 * @Company: Macroview
 */
package com.yue.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@Entity
@Table(name="toby")
public class Toby extends IdEntity{

	private String name;
	
	private String sex;
	
	private String telephone;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Toby [name=" + name + ", sex=" + sex + "]";
	}
}
