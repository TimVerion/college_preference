package com.project.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.project.dao.UserDao;
import com.project.domain.User;
import com.project.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{

	@Override
	/**
	 * 用户注册
	 * */
	public void save(User user) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?);";
		qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode());
		
	}

	
	/**
	 * 通过激活码获取用户
	 * */

	public User getByCode(String code) throws Exception {
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where code = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class), code);
	}

	/**
	 * 更新用户
	 * */
	public void update(User user) throws Exception {
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set password = ?, sex=?, state= ?, code=? where uid=?";
		qr.update(sql, user.getPassword(), user.getSex(), user.getState(), user.getCode(), user.getUid());
	}


	/**
	 * 用户登录
	 * */
	public User getByUsernameAndPwd(String username, String password) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username= ? and password= ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class), username, password);
	}


	@Override
	public List<User> findAll() {
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user";
		try {
			return qr.query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	

}
