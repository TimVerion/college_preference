package com.project.service.impl;

import java.util.List;

import com.project.dao.CollegeDao;
import com.project.dao.ZyInfoDao;
import com.project.domain.PageBean;
import com.project.domain.College;
import com.project.domain.ZyInfo;
import com.project.service.CollegeService;
import com.project.utils.BeanFactory;

public class CollegeServiceImpl implements CollegeService {

	@Override
	public List<College> findHot() throws Exception {
		CollegeDao pd= (CollegeDao) BeanFactory.getBean("CollegeDao");
		return pd.findHot();
	}

	@Override
	public List<College> findNew() throws Exception {
		CollegeDao pd= (CollegeDao) BeanFactory.getBean("CollegeDao");
		return pd.findNew();
	}

	@Override
	public College getById(String pid) throws Exception {
		CollegeDao pd= (CollegeDao) BeanFactory.getBean("CollegeDao");
		return pd.getById(pid);
	}

	@Override
	public PageBean<College> findByPage(int pageNumber, int pageSize, String cid,String pname){
		CollegeDao pDao=(CollegeDao) BeanFactory.getBean("CollegeDao");
		//1.创建pagebean
		PageBean<College> pb=new PageBean<>(pageNumber,pageSize);
		
		//2.设置当前页数据
		List<College> data;
		data = pDao.findByPage(pb,cid,pname);
		pb.setData(data);
		
		//3.设置总记录数
		int totalRecord;
		try {
			totalRecord = pDao.getTotalRecord(cid,pname);
			pb.setTotalRecord(totalRecord);
		} catch (Exception e) {
			System.out.println("total出错");
		}
		
		return pb;
	}

	@Override
	/**
	 * 后台展示已上架商品
	 * */
	public List<College> findAll() throws Exception {
		CollegeDao pDao=(CollegeDao) BeanFactory.getBean("CollegeDao");
		return pDao.findAll();
	}

	@Override
	/**
	 * 保存商品
	 * */
	public void save(College p) throws Exception {
		CollegeDao pDao=(CollegeDao) BeanFactory.getBean("CollegeDao");
		pDao.save(p);
		
	}

	@Override
	public void update(College p) throws Exception {
		CollegeDao pDao=(CollegeDao) BeanFactory.getBean("CollegeDao");
		pDao.update(p);
	}

	@Override
	public void delByPid(String pid) throws Exception {
		CollegeDao pDao=(CollegeDao) BeanFactory.getBean("CollegeDao");
		pDao.delByPid(pid);
	}

	@Override
	public void saveZyInfo(ZyInfo z) {
		ZyInfoDao zDao=(ZyInfoDao) BeanFactory.getBean("ZyInfoDao");
		zDao.save(z);
	}
}

