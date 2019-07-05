package com.project.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.project.constant.Constant;
import com.project.dao.CollegeDao;
import com.project.domain.PageBean;
import com.project.domain.College;
import com.project.utils.DataSourceUtils;
@SuppressWarnings("all")
public class CollegeDaoImpl implements CollegeDao {
 
	@Override
	public List<College> findHot() throws Exception {
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		String sql= "select * from college where is_hot = ? and pflag= ? order by pdate desc limit 9";
		return qr.query(sql, new BeanListHandler<>(College.class), Constant.COOLEGE_IS_HOT, Constant.COOLEGE_IS_UP);
	}

	@Override
	public List<College> findNew() throws Exception {
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		String sql= "select * from college where pflag= ? order by pdate desc limit 9";
		return qr.query(sql, new BeanListHandler<>(College.class), Constant.COOLEGE_IS_UP);
	}

	@Override
	public College getById(String pid) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from college where pid= ? limit 1";
		return qr.query(sql, new BeanHandler<>(College.class), pid);
	}

	@Override
	public List<College> findByPage(PageBean<College> pb, String cid,String pname){
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from college where pflag= ? ";
		StringBuilder sb = new StringBuilder(sql);
		List params = new ArrayList();
		params.add(Constant.COOLEGE_IS_UP);
		if (cid != null && !cid.equals("null")){
			sb.append("and cid = ? ");
			params.add(cid);
		}
		if (pname!=null&&pname.length()>0)
		{
			sb.append("and pname like ? ");
			params.add("%"+pname+"%");
		}
		sb.append("order by pdate desc limit ?,?");
		params.add(pb.getStartIndex());
		params.add(pb.getPageSize());
		try {
			return qr.query(sb.toString(), new BeanListHandler<>(College.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * 获取总记录数 
	 * */
	public int getTotalRecord(String cid,String pname) throws Exception {
		String sql ="select count(*) from college where pflag = ? ";
		StringBuilder sb =new StringBuilder(sql);
		List params = new ArrayList();
		params.add(Constant.COOLEGE_IS_UP);
		if (cid != null && !cid.equals("null")){
			sb.append("and cid = ? ");
			params.add(cid);
		}
		if (pname!=null&&pname.length()>0)
		{
			sb.append("and pname like ? ");
			params.add("%"+pname+"%");
		}
		return ((Long)new QueryRunner(DataSourceUtils.getDataSource()).query(sb.toString(), new ScalarHandler(),params.toArray())).intValue();
	}

	@Override
	public List<College> findAll() throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from college where pflag = ? order by pdate desc";
		return qr.query(sql, new BeanListHandler<>(College.class), Constant.COOLEGE_IS_UP);
	}

	@SuppressWarnings("unused")
	@Override
	public void save(College p) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into college values(?,?,?,?,?,?,?,?,?,?);";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String date = format.format(d);
		qr.update(DataSourceUtils.getConnection(),sql,p.getPid(),p.getPname(),p.getMarket_line(),
				p.getNow_line(),p.getPimage(),date,
				"1",p.getPdesc(),0,
				p.getCategory().getCid());
		
		
	}

	@Override
	public void update(College p) throws Exception {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update college set pname=?,market_line = ?,now_line=?,pimage=?,pdate = ?,is_hot = ?,pdesc = ?,pflag = ?,cid = ? where pid =?";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		qr.update(DataSourceUtils.getConnection(),sql,p.getPname(),p.getMarket_line(),
				p.getNow_line(),p.getPimage(),format.format(p.getPdate()),
				p.getIs_hot(),p.getPdesc(),p.getPflag(),
				p.getCategory().getCid(),p.getPid());
	}

	@Override
	public void delByPid(String pid) throws Exception {
		String sql = "delete from college where pid = ? ";
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		qr.update(DataSourceUtils.getConnection(),sql,pid);
	}
}
