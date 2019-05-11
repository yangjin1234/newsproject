package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Type;
import dao.TypeDao;

public class TypeDaoImpl implements TypeDao{

	public List<Type> selectAllType(Connection conn) throws Exception {
		String sql="select * from type";
		List<Type> list=new ArrayList<Type>();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Type t=new Type();
			t.setTid(rs.getInt("tid"));
			
		}
		return null;
	}

}
