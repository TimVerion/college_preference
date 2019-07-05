package com.project.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.domain.User;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;
import com.project.web.servlet.base.BaseServlet;

public class AdminUserServlet  extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserServiceImpl();
		List<User> lists = us.findAll();
		request.setAttribute("lists", lists);
		return "admin/user/list.jsp";
	}
}
