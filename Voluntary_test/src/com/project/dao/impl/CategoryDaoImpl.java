package com.project.dao.impl;

import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.project.dao.CategoryDao;
import com.project.domain.Category;
import com.project.utils.DataSourceUtils;

public class CategoryDaoImpl implements CategoryDao {
	
	/**
	 * 查询所有分类
	 * */
	public List<Category> findAll() throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		return qr.query(sql, new BeanListHandler<>(Category.class));
	}

	@Override
	/**
	 * 添加分类
	 * */
	public void save(Category c) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into category values (?,?)";
		qr.update(sql, c.getCid(),c.getCname());
		
	}

}
