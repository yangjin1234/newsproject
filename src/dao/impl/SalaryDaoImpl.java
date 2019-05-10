package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import pojo.Salary;
import util.GetDate;
import util.MyLog;
import dao.SalaryDao;
import db.DBHelper;

public class SalaryDaoImpl implements SalaryDao {

	public ArrayList<Salary> getAll(Connection conn)throws Exception {
		ArrayList<Salary> list=new ArrayList<Salary>();
		String sql="select * from salary";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setTimestamp(1, GetDate.getNowDate2("2019-05-05 21:52:21"));
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Salary s=new Salary();
			s.setSid(rs.getInt("sid"));
			s.setSid_uid_key(rs.getInt("sid_uid_key"));
			s.setSalarys_state(rs.getInt("salarys_state"));
			s.setSalarys(rs.getDouble("salarys"));
			s.setSdate(rs.getDate("sdate"));
			list.add(s);
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		System.out.println( GetDate.getNowDate2(GetDate.getNowDate()));
	}
	
}
