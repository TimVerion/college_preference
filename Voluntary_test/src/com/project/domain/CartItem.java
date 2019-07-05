package com.project.domain;
public class CartItem {
	private College college;
	private Double subtotal;
	private Integer count;
	public College getCollege() {
		return college;
	}
	public void setCollege(College product) {
		this.college = college;
	}
	public Double getSubtotal() {
		return college.getNow_line()*count;
	}


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public CartItem(College college, Integer count) {
		super();
		this.college = college;
		this.count = count;
	}
	

}
