package com.project.service.impl;

import java.util.List;

import com.project.utils.BeanFactory;
import com.project.utils.JedisUtils;
import com.project.utils.JsonUtil;

import redis.clients.jedis.Jedis;

import com.project.constant.Constant;
import com.project.dao.CategoryDao;
import com.project.dao.impl.CategoryDaoImpl;
import com.project.domain.Category;
import com.project.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	/**
	 * 后台展示所有分类
	 */
	public List<Category> findList() throws Exception {
		CategoryDao cd = (CategoryDao) BeanFactory.getBean("CategoryDao");
		return cd.findAll();
	}

	@Override
	/**
	 * 查询所有分类
	 */
	public String findAll() throws Exception {
		List<Category> list=findList();
		if(list!=null && list.size()>0){
			return JsonUtil.list2json(list);
		}
		return null;
	}

	@Override
	/**
	 * 从redis中获取所有的分类
	 */
	public String findAllFromRedis() throws Exception {
		Jedis j =null;
		String value=null;
		try {
			//1.从redis获取分类信息
			try {
				//1.1获取连接
				j = JedisUtils.getJedis();
				
				//1.2 获取数据 判断数据是否为空
				value = j.get(Constant.PHONEMALL_CATEGORY_LIST);
				
				//1.3 若不为空,直接返回数据
				if(value!=null){
					System.out.println("缓存中有数据");
					return value;
				}
			} catch (Exception e) {
			}
			
			//2 redis中 若无数据,则从mysql数据库中获取  别忘记将数据并放入redis中
			value = findAll();
					
			
			//3.将value放入redis中
			try {
				j.set(Constant.PHONEMALL_CATEGORY_LIST, value);
				System.out.println("已经将数据放入缓存中");
			} catch (Exception e) {
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//释放jedis
			JedisUtils.closeJedis(j);
		}
		
		return value;
	}

	@Override
	/**
	 * 添加分类
	 */
	public void save(Category c) throws Exception {
		//1.调用dao 完成添加
		CategoryDao cd = (CategoryDao) BeanFactory.getBean("CategoryDao");
		cd.save(c);
		
		//2.更新redis
		Jedis j = null;
		try {
			j=JedisUtils.getJedis();
			//清除redis中数据
			j.del(Constant.PHONEMALL_CATEGORY_LIST);
		} finally {
			JedisUtils.closeJedis(j);
		}
	}

	
}
