package com.project.domain;

import java.util.List;

/**
 * 分页实体
 */
public class PageBean<T> {
	private int pageNumber;//当前页面
	private int pageSize;//每页显示的条数
	private int totalRecord;//总条数 查询出来
	private int totalPage;//总页数	计算
	private List<T> data;//当前页的数据 查询 
	private int startIndex;//limit后面的m (pageNumber-1)*pageSize
	
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	/**
	 * 获取总页数
	 */
	public int getTotalPage() {
		return (int) Math.ceil(this.totalRecord*1.0/pageSize);
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getStartIndex() {
		return (this.pageNumber-1)*this.pageSize;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public PageBean() { }
	
	
	public PageBean(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	
	
	
}
