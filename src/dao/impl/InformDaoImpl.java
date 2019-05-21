package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Inform;
import util.GetDate;
import util.creatkey;
import dao.InformDao;

public class InformDaoImpl implements InformDao{


	public List<Inform> selectInform(Connection conn) throws Exception {
		String sql="select * from inform";
		PreparedStatement ps=conn.prepareStatement(sql);
		List<Inform> list=new ArrayList<Inform>();
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Inform inform=new Inform();
			inform.setIid(rs.getInt("iid"));
			inform.setItitle(rs.getString("ititle"));
			inform.setItime(rs.getDate("itime"));
			inform.setIcontent(rs.getString("icontent"));
			inform.setIstate(rs.getInt("istate"));
			list.add(inform);
		}
		return list;
	}

	public boolean insertOneInform(Connection conn, Inform inform)
			throws Exception {
		String sql="insert into inform values(?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, creatkey.getCeartKey());
		ps.setString(2, inform.getItitle());
		ps.setString(3,inform.getIcontent());
		ps.setTimestamp(4, GetDate.getNowDate2(GetDate.getNowDate()));
		ps.setInt(5, 1);
		int n=ps.executeUpdate();
		if(n>0){
			return  true;
		}
		return false;
	}
}
