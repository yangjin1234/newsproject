package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Type;
import pojo.impl.TypeImpl;
import dao.TypeDao;

public class TypeDaoImpl implements TypeDao{

	/**
	 * 查出所有类型，以及统计数量
	 */
	public List<TypeImpl> selectAllType(Connection conn) throws Exception {
		String sql="select *,count(*) as number from type group by tname";
		List<TypeImpl> list=new ArrayList<TypeImpl>();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			TypeImpl t=new TypeImpl();
			t.setTid(rs.getInt("tid"));
			t.setTid_nid_key(rs.getInt("tid_nid_key"));
			t.setTname(rs.getString("tname"));
			t.setNumber(rs.getInt("number"));
			list.add(t);
		}
		return list;
	}

}
