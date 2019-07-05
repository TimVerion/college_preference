package com.project.utils;

import com.project.constant.Constant;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	//创建连接池
	private static final JedisPoolConfig config;
	private static final JedisPool pool;
	
	static{
		config=new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(2);
		
		pool=new JedisPool(config,Constant.REDIS_HOST , Constant.REDIS_PORT);
	}
	
	
	//获取连接的方法
	public static Jedis getJedis(){
		return pool.getResource();
	}
	
	
	//释放连接
	public static void closeJedis(Jedis j){
		if(j!=null){
			j.close();
		}
	}
}
