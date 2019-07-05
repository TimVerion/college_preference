package com.project.domain;


public class College {
	private String pid;
	private String pname;
	private Double market_line;
	
	private Double now_line;
	private String pimage;
	private String pdate;
	private Integer is_hot; //是否热门 1:热门 2:不热门
	private String pdesc;
	private Integer pflag; 
	private Category category;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}



	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}


	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Integer getPflag() {
		return pflag;
	}

	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getMarket_line() {
		return market_line;
	}

	public void setMarket_line(Double market_line) {
		this.market_line = market_line;
	}

	public Double getNow_line() {
		return now_line;
	}

	public void setNow_line(Double now_line) {
		this.now_line = now_line;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "College [pid=" + pid + ", pname=" + pname + ", market_line="
				+ market_line + ", now_line=" + now_line + ", pimage=" + pimage
				+ ", pdate=" + pdate + ", is_hot=" + is_hot + ", pdesc="
				+ pdesc + ", pflag=" + pflag + ", category=" + category + "]";
	}

	
}
