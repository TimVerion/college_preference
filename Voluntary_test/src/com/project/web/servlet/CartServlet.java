package com.project.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.domain.Cart;
import com.project.domain.CartItem;
import com.project.domain.College;
import com.project.domain.ZyInfo;
import com.project.service.CollegeService;
import com.project.utils.BeanFactory;
import com.project.web.servlet.base.BaseServlet;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getCart(request).clearCart();
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		
		return null;
	}
	
	public String remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		getCart(request).removeFromCart(pid);
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}
	
	public String add2cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pid=request.getParameter("pid");
			int count=Integer.parseInt(request.getParameter("count"));
			CollegeService ps=(CollegeService) BeanFactory.getBean("CollegeService");
			College college=ps.getById(pid);
			CartItem cartItem=new CartItem(college, count);
			Cart cart=getCart(request);
			cart.add2cart(cartItem);
			response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "专家较忙，排队失败");
			return "/jsp/msg.jsp";
		}
		
		return null;
	}
	public String tozj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			Collection<CartItem> cs = cart.getCartItems();
			List<College> lists = new ArrayList<College>();
			for (CartItem cartItem : cs) {
				lists.add(cartItem.getCollege());
			}
			request.setAttribute("lists", lists);
			return "/jsp/zyinfo.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "专家较忙，排队失败");
			return "/jsp/msg.jsp";
		}
	}

	private Cart getCart(HttpServletRequest request) {
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		if (cart==null) {
			cart=new Cart();
			
			//将cart放入session中
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	public String saveInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String idcard = request.getParameter("idcard");
			String birthday = request.getParameter("birthday");
			String sbcard = request.getParameter("sbcard");
			String home = request.getParameter("home");
			String st = request.getParameter("st");
			String zzmm = request.getParameter("zzmm");
			String mz = request.getParameter("mz");
			String province1 = request.getParameter("province1");
			String address1 = request.getParameter("address1");
			String province2 = request.getParameter("province2");
			String address2 = request.getParameter("address2");
			String phone = request.getParameter("phone");
			String otherphone = request.getParameter("otherphone");
			String school = request.getParameter("school");
			String worl = request.getParameter("worl");
			String graduationtime = request.getParameter("graduationtime");
			String schooling = request.getParameter("schooling");
			String degree = request.getParameter("degree");
			String bz = request.getParameter("bz").trim();
			ZyInfo z = new ZyInfo(name, sex, idcard, birthday, sbcard, home, st, zzmm, mz, province1, address1, province2, address2, phone, otherphone, school, worl, graduationtime, schooling, degree, bz);
			CollegeService ps=(CollegeService) BeanFactory.getBean("CollegeService");
			ps.saveZyInfo(z);
			request.setAttribute("msg", "提交成功,请随时打开手机准备接听!");
			getCart(request).clearCart();
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "专家较忙，排队失败");
			return "/jsp/msg.jsp";
		}
	}
}
