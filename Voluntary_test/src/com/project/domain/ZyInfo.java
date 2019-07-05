package com.project.domain;

public class ZyInfo {
	Integer zyid;
	String name = "zs";
	String sex = "n";
	String idcard = "n";
	String birthday = "n";
	String sbcard = "n";
	String home = "n";
	String st = "n";
	String zzmm = "n";
	String mz = "n";
	String province1 = "n";
	String address1 = "n";
	String province2 = "n";
	String address2 = "n";
	String phone = "n";
	String otherphone = "n";
	String school = "n";
	String worl = "n";
	String graduationtime = "n";
	String schooling = "n";
	String degree = "n";
	String bz = "n";

	public Integer getZyid() {
		return zyid;
	}

	public void setZyid(Integer zyid) {
		this.zyid = zyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSbcard() {
		return sbcard;
	}

	public void setSbcard(String sbcard) {
		this.sbcard = sbcard;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getProvince1() {
		return province1;
	}

	public void setProvince1(String province1) {
		this.province1 = province1;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getProvince2() {
		return province2;
	}

	public void setProvince2(String province2) {
		this.province2 = province2;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOtherphone() {
		return otherphone;
	}

	public void setOtherphone(String otherphone) {
		this.otherphone = otherphone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getWorl() {
		return worl;
	}

	public void setWorl(String worl) {
		this.worl = worl;
	}

	public String getGraduationtime() {
		return graduationtime;
	}

	public void setGraduationtime(String graduationtime) {
		this.graduationtime = graduationtime;
	}

	public String getSchooling() {
		return schooling;
	}

	public void setSchooling(String schooling) {
		this.schooling = schooling;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public ZyInfo(String name, String sex, String idcard, String birthday,
			String sbcard, String home, String st, String zzmm, String mz,
			String province1, String address1, String province2,
			String address2, String phone, String otherphone, String school,
			String worl, String graduationtime, String schooling,
			String degree, String bz) {
		super();
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.birthday = birthday;
		this.sbcard = sbcard;
		this.home = home;
		this.st = st;
		this.zzmm = zzmm;
		this.mz = mz;
		this.province1 = province1;
		this.address1 = address1;
		this.province2 = province2;
		this.address2 = address2;
		this.phone = phone;
		this.otherphone = otherphone;
		this.school = school;
		this.worl = worl;
		this.graduationtime = graduationtime;
		this.schooling = schooling;
		this.degree = degree;
		this.bz = bz;
	}

	@Override
	public String toString() {
		return "ZyInfo [zyid=" + zyid + ", name=" + name + ", sex=" + sex
				+ ", idcard=" + idcard + ", birthday=" + birthday + ", sbcard="
				+ sbcard + ", home=" + home + ", st=" + st + ", zzmm=" + zzmm
				+ ", mz=" + mz + ", province1=" + province1 + ", address1="
				+ address1 + ", province2=" + province2 + ", address2="
				+ address2 + ", phone=" + phone + ", otherphone=" + otherphone
				+ ", school=" + school + ", worl=" + worl + ", graduationtime="
				+ graduationtime + ", schooling=" + schooling + ", degree="
				+ degree + ", bz=" + bz + "]";
	}

}
