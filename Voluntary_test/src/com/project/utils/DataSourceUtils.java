package com.project.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl=new ThreadLocal<>();
	
	/**
	 * 获取数据源
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/**
	 * 从线程中获取连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn = tl.get();
		//若是第一次获取 需要从池中获取一个连接,将这个连接和当前线程绑定
		if(conn==null){
			conn=ds.getConnection();
			
			//将这个连接和当前线程绑定
			tl.set(conn);
		}
		
		return conn;
	}
	
	
	
	/**
	 * 释放资源
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
	 * 释放连接
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				//和当前线程解绑
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * 释放语句执行者
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	/**
	 * 释放结果集
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}
	
	/**
	 * 开始事务
	 */
	public static void startTransaction() throws SQLException{
		//1.获取连接
		Connection conn=getConnection();
		
		//2.开始
		conn.setAutoCommit(false);
	}
	
	/**
	 * 事务提交
	 */
	public static void commitAndClose(){
		try {
			//0.获取连接
			Connection conn = getConnection();
			
			//1.提交事务
			conn.commit();
			
			//2.关闭且移除
			closeConn(conn);
		} catch (SQLException e) {
		}
		
	}
	
	/**
	 * 提交回顾
	 */
	public static void rollbackAndClose(){
		try {
			//0.获取连接
			Connection conn = getConnection();
			
			//1.事务回顾
			conn.rollback();
			
			//2.关闭且移除
			closeConn(conn);
		} catch (SQLException e) {
		}
		
	}
}
