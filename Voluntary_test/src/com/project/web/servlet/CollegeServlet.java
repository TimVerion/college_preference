package com.project.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.domain.PageBean;
import com.project.domain.College;
import com.project.service.CollegeService;
import com.project.service.impl.CollegeServiceImpl;
import com.project.web.servlet.base.BaseServlet;

public class CollegeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 分类商品分页展示
	 * */
	public String findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pname =request.getParameter("pname");
			int pageNumber=1;
			
			try {
				pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
			} catch (NumberFormatException e) {
			}
			
			int pageSize=12;
			String cid=request.getParameter("cid");
			
			CollegeService ps=new CollegeServiceImpl();
			PageBean<College> bean=ps.findByPage(pageNumber,pageSize,cid,pname);
			request.setAttribute("pname", pname);
			request.setAttribute("pb", bean);
		} catch (Exception e) {
			request.setAttribute("msg", "分页查询失败");
			return "/jsp/msg.jsp";
		}
		return "/jsp/product_list.jsp";
	}
	
	
	public String getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pid=request.getParameter("pid");
			CollegeService ps=new CollegeServiceImpl();
			College pro=ps.getById(pid);
			request.setAttribute("bean", pro);
		} catch (Exception e) {
			request.setAttribute("msg", "查询大学失败");
			return "/jsp/msg.jsp";
		}
		return "/jsp/product_info.jsp";
	} 

    
}
