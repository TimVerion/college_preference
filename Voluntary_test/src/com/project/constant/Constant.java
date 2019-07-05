package com.project.constant;

public interface Constant {
	/*
	 *用户未激活
	 * */
	int USER_IS_NOT_ACTIVE =0;
	
	/*
	 *用户已激活
	 * */
	int USER_IS_ACTIVE =1;
	
	/**
	 * 记住用户名
	 * */
	String SAVE_NAME = "ok";
	
	/**
	 * 热门学校
	 * */
	int COOLEGE_IS_HOT = 1;
	
	/**
	 * 高校招收
	 * */
	int COOLEGE_IS_UP = 0;
	
	/**
	 * 暂时关闭高校招收
	 * */
	int COOLEGE_IS_DOWN = 1;
	
	/**
	 * 订单状态 未付款
	 * */
	int ORDER_WEIFUKUAN=0;
	/**
	 * 订单状态 已付款
	 * */
	int ORDER_YIFUKUAN=1;
	/**
	 * 订单状态 已发货
	 * */
	int ORDER_YIFAHUO=2;
	/**
	 * 订单状态 已完成
	 * */
	int ORDER_YIWANCHENG=3;

	/**
	 * REDIS中存储分类列表的key
	 * */
	String PHONEMALL_CATEGORY_LIST= "PHONEMALL_CATEGORY_LIST";
	
	/**
	 * REDIS的服务器地址
	 * */
	String REDIS_HOST="127.0.0.1";
	
	/**
	 * REDIS的服务器端口号
	 * */
	int REDIS_PORT= 6379;

}
