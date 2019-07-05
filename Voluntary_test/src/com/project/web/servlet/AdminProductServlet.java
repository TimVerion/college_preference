package com.project.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.domain.Category;
import com.project.domain.College;
import com.project.service.CategoryService;
import com.project.service.CollegeService;
import com.project.service.impl.CategoryServiceImpl;
import com.project.utils.BeanFactory;
import com.project.web.servlet.base.BaseServlet;

/**
 * 后台大学模块
 */
public class AdminProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CollegeService ps=(CollegeService) BeanFactory.getBean("CollegeService");
			List<College> list=ps.findAll();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return "admin/product/list.jsp";
	}

	public String toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "admin/product/add.jsp";
	}
	public String delbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CollegeService ps=(CollegeService) BeanFactory.getBean("CollegeService");
			String pid = request.getParameter("pid");
			ps.delByPid(pid);
			List<College> list=ps.findAll();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return "admin/product/list.jsp";
	}
	public String toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CollegeService ps=(CollegeService) BeanFactory.getBean("CollegeService");
			CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
			String pid = request.getParameter("pid");
			College pro = ps.getById(pid);
			List<Category> cts = cs.findList();
			request.setAttribute("pro", pro);
			request.setAttribute("cts", cts);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return "admin/product/edit.jsp";
	}
}
