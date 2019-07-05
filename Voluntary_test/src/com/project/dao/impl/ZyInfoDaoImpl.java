package com.project.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

import com.project.dao.ZyInfoDao;
import com.project.domain.ZyInfo;
import com.project.utils.DataSourceUtils;

public class ZyInfoDaoImpl implements ZyInfoDao{

	@Override
	public void save(ZyInfo z) {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into zyinfo values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(DataSourceUtils.getConnection(),sql,
					z.getName(),z.getSex(),z.getIdcard(),z.getBirthday(),z.getSbcard(),
					z.getHome(),z.getSt(),z.getZzmm(),z.getMz(),z.getProvince1(),
					z.getAddress1(),z.getProvince2(),
					z.getAddress2(),z.getPhone(),z.getOtherphone(),
					z.getSchool(),z.getWorl(),z.getGraduationtime(),z.getSchooling(),
					z.getDegree(),z.getBz());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
