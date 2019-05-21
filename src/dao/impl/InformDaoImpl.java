package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.Inform;
import dao.InformDao;

public class InformDaoImpl implements InformDao{


	public Inform selectInform(Connection conn) throws Exception {
		String sql="select * from inform";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Inform inform=new Inform();
		if(rs.next()){
			inform.setIid(rs.getInt("iid"));
			inform.setItitle(rs.getString("ititle"));
			inform.setItime(rs.getDate("itime"));
			inform.setIcontent(rs.getString("icontent"));
			inform.setIstate(rs.getInt("istate"));
			return inform;
		}
		return null;
	}
}
