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


	public List<Inform> selectInform(Connection conn,int pageNo,int pageSize) throws Exception {
		String sql="select * from inform where istate=1 limit ?,?";
		PreparedStatement ps=conn.prepareStatement(sql);
		List<Inform> list=new ArrayList<Inform>();
		 ps.setInt(1, (pageNo-1)*pageSize);
		  ps.setInt(2, pageSize);
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

	public int selectInformMaxPage(Connection conn, int pageSize)
			throws Exception {
		 String sql="select count(*) as max from inform where istate=1";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  if(rs.next())
			  {
				  count=rs.getInt("max");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
}
