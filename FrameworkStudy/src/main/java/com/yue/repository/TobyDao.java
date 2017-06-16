/**
 * @Copyright:Copyright (c) 1991 - 2015
 * @Company: Macroview
 */
package com.yue.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.yue.entity.Toby;


/**
 *  
 * @author Toby
 * @since: v1.0
 */
public interface TobyDao extends PagingAndSortingRepository<Toby, Long>{

	@Query(value="SELECT * FROM toby WHERE id = ?1 and name like %?2%", nativeQuery = true)
	public Toby findByIdAndName(long id,String name);

}
