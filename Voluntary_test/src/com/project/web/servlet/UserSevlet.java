package com.project.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.codegen.bean.BeangenUtils;
import com.project.constant.Constant;
import com.project.domain.User;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;
import com.project.utils.UUIDUtils;
import com.project.web.servlet.base.BaseServlet;

/**
 * 用户模块
 */
public class UserSevlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 退出
	 * */
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		
		response.sendRedirect(request.getContextPath());
		return null;
	}
	
	/**
	 * 用户登录
	 * */
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.获取用户名和密码
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			//2.调用service完成登录 返回值：user
			UserService us=new UserServiceImpl();
			User user=us.login(username, password);
			
			//3.判断user 根据结果生成提示信息
			if (user==null) {
				//用户名和密码不匹配
				request.setAttribute("msg","用户名和密码不匹配");
				return "/jsp/login.jsp";
			}
			
			//若用户不为空，继续判断是否激活
			if (Constant.USER_IS_ACTIVE !=user.getState()) {
				//未激活
				request.setAttribute("msg", "请先激活邮箱再登录！");
				return "/jsp/msg.jsp";
			}
			
			//登录成功 保存用户的登录状态
			request.getSession().setAttribute("user", user);
			
			/////////////记住用户名/////////////////
			//判断是否勾选了记住用户名
			if (Constant.SAVE_NAME.equals(request.getParameter("savename"))) {
				Cookie c=new Cookie("saveName", URLEncoder.encode(username, "utf-8"));
				
				c.setMaxAge(Integer.MAX_VALUE);
				c.setPath(request.getContextPath()+"/");
				
				response.addCookie(c);
				
			}
			//////////////////////////////////////
			
			//跳转到index.jsp
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "用户登录失败！");
			return "/jsp/msg.jsp";
		}
		
		return null;
	}
	
	/**
	 * 跳转到登录页面
	 * */
	public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/login.jsp";
	}
	
	/**
	 * 用户激活
	 * */
	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.接收code
			String code= request.getParameter("code");
			
			//2.调用service完成激活 返回值：user
			UserService us=new UserServiceImpl();
			User user=us.active(code);
			
			//3.判断user 生成不同的提升信息
			if (user==null) {
				//没有找到这个用户，激活失败
				request.setAttribute("msg", "激活失败，请重新激活或者重新注册！");
				return "/jsp/msg.jsp";
				
			}
			
			//激活成功
			request.setAttribute("msg", "恭喜您！激活成功！可以登录啦！");
		} catch (Exception e) {
			request.setAttribute("msg", "激活失败，请重新激活或者重新注册！");
			return "/jsp/msg.jsp";
		}
		return "/jsp/msg.jsp";
	}
	

	
	/**
	 * 用户注册
	 * */
	public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.封装对象
			User user=new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			//1.1手动封装uid
			user.setUid(UUIDUtils.getId());
			
			//1.2手动封装激活码code
			user.setState(Constant.USER_IS_ACTIVE);
			
			//1.3手动封装激活状态state
			user.setCode(UUIDUtils.getCode());
			
			//2.调用service完成注册
			UserService us=new UserServiceImpl();
			us.regist(user);
			
			//3.页面转发，提示信息
			request.setAttribute("msg", "恭喜您，注册成功！请直接<a href='jsp/login.jsp'>登陆！</a>");
		}  catch (Exception e) {
			e.printStackTrace();
			//转发到msg.jsp
			request.setAttribute("msg", "用户注册失败！");
			return "/jsp/msg.jsp";
		}
		return "/jsp/msg.jsp";
	}
	
	/*
	 * 跳转到注册页面
	 * */
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
	}

	

}
