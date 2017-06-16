/**
 * @Copyright:Copyright (c) 1991 - 2015
 * @Company: Macroview
 */
package com.yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yue.entity.Toby;
import com.yue.repository.TobyDao;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
@Component
@Transactional
public class TobyService {

	@Autowired
	private TobyDao tobyDao;
	
	public void save(Toby toby){
		tobyDao.save(toby);
	}

	public Toby getToby() {
		return tobyDao.findOne(1L);
	}
	
	public Page<Toby> pageBy(Pageable pageable){
		return tobyDao.findAll(pageable);
	}

	public Toby findByIdAndName(long id, String name) {
		return tobyDao.findByIdAndName(id,name);
	}

	public Iterable<Toby> findAll() {
		return tobyDao.findAll();
	}
}
