package com.project.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.domain.Category;
import com.project.service.CategoryService;
import com.project.utils.BeanFactory;
import com.project.utils.UUIDUtils;
import com.project.web.servlet.base.BaseServlet;

/**
 * 后台分类管理模块
 */
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 添加分类
	 * */
	public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.封装category对象
			Category c=new Category();
			c.setCid(UUIDUtils.getId());
			c.setCname(request.getParameter("cname"));
			
			//2.调用service 完成添加操作
			CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
			cs.save(c);
			
			//3.重定向
			response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return null;
	}
	
	/**
	 * 跳转到添加页面
	 * */
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//调用categoryservice 查询所有分类
			CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
			
			request.setAttribute("list", cs.findList());
		} catch (Exception e) {
		}
		return "/admin/product/add.jsp";
	}
	
	/**
	 * 展示所有分类
	 * */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1.调用service 获取所有分类
			CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
			List<Category> list=cs.findList();
			
			
			//2.将返回值放入request域中 请求转发
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return "/admin/category/list.jsp";
	}
}
