/**
 * @Copyright:Copyright (c) 1991 - 2015
 * @Company: Macroview
 */
package com.yue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.yue.entity.User;
import com.yue.entity.User_core;


/**
 *  
 * @author Toby
 * @since: v1.0
 */
public interface User_coreDao extends PagingAndSortingRepository<User_core, Long>{

	@Query(value = "SELECT * FROM user_core WHERE telephone like ?1", nativeQuery = true)
	public List<User_core> findlike(String a);
}
