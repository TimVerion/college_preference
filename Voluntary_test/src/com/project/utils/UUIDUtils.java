package com.project.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 随机生成id
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 生成随机码
	 */
	public static String getCode(){
		return getId();
	}
}
