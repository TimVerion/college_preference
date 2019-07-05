package com.project.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> itemMap=new HashMap<String,CartItem>();
	private Double total=0.0;
	public Collection<CartItem> getCartItems(){
		return itemMap.values();
	}
	public Map<String, CartItem> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<String, CartItem> itemMap) {
		this.itemMap = itemMap;
	}
	public Double getTotal() {
		
		
		return 0.87;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	/**
	 * 加入购物车
	 * */
	public void add2cart(CartItem item) {
		//获取商品的id
		String pid=item.getCollege().getPid();
		
		//1.判断购物车中是否有
		if (itemMap.containsKey(pid)) {
			//有 修改数量=原来数量+添加数量
			//原有的购物项
			CartItem oItem=itemMap.get(pid);
			
			oItem.setCount(oItem.getCount()+item.getCount());	
		} else {
			//无
			itemMap.put(pid, item);
		}
		
		//2.修改总金额
		total+=item.getSubtotal();
	}
	
	/**
	 * 从购物车移除一个商品项
	 * */
	public void removeFromCart(String pid) {
		//1.从购物车(map)移除商品项
		CartItem item=itemMap.remove(pid);
		
		//2.修改总金额
		total-=item.getSubtotal();
		
	}
	
	/**
	 * 清空购物车
	 * */
	public void clearCart() {
		//1.清空map
		itemMap.clear();
		
		//2.修改总金额=0
		total=0.0;
		
	}

}
