package com.project.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.service.CategoryService;
import com.project.service.impl.CategoryServiceImpl;
import com.project.web.servlet.base.BaseServlet;

/**
 * 前台分类模块
 */
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询所有分类
	 * */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//0.设置响应编码
			response.setContentType("text/html;charset=utf-8");
			
			//1.调用service查询所有分类，返回值json字符串
			CategoryService cs=new CategoryServiceImpl();
			//从mysql获取列表
			String value=cs.findAll();
			
			//从redis中获取列表
			//String value=cs.findAllFromRedis();
			//2.将字符串写回浏览器
			response.getWriter().println(value);
		} catch (Exception e) {
		}
		return null;
	}

    /**
     * Default constructor. 
     */
    public CategoryServlet() {
        // TODO Auto-generated constructor stub
    }

}
