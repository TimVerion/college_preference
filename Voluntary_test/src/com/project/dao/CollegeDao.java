package com.project.dao;

import java.util.List;

import com.project.domain.PageBean;
import com.project.domain.College;

public interface CollegeDao {

	List<College> findHot() throws Exception;

	List<College> findNew() throws Exception;

	College getById(String pid) throws Exception;

	List<College> findByPage(PageBean<College> pb, String cid, String pname);

	int getTotalRecord(String cid, String pname) throws Exception;

	List<College> findAll() throws Exception;

	void save(College p) throws Exception;

	void update(College p) throws Exception;
	
	void delByPid(String pid) throws Exception;
	
	//List<Product> findProductByName(PageBean<Product> p, String pname) throws Exception;
	
	//Product findProductByName(String name) throws Exception;
	
	

}
