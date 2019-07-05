package com.project.service;

import java.util.List;

import com.project.domain.PageBean;
import com.project.domain.College;
import com.project.domain.ZyInfo;

public interface CollegeService {

	List<College> findHot() throws Exception;

	List<College> findNew() throws Exception;

	College getById(String pid) throws Exception;

	PageBean<College> findByPage(int pageNumber, int pageSize, String cid,
			String pname);

	List<College> findAll() throws Exception;

	void save(College p) throws Exception;

	void update(College p) throws Exception;

	void delByPid(String pid) throws Exception;

	void saveZyInfo(ZyInfo z);

}
