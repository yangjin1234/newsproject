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
	 * ����������ͣ��Լ�ͳ������
	 */
	public List<TypeImpl> selectAllType(Connection conn) throws Exception {
		String sql="select  tname,tid,count(*) as number   from news,type WHERE type.tid=news.nid_tid_key group by news.nid_tid_key";
		List<TypeImpl> list=new ArrayList<TypeImpl>();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			TypeImpl t=new TypeImpl();
			t.setTid(rs.getInt("tid"));
			t.setTid_nid_key(1);//���ݿ����ʧ�󣬸�����������
			t.setTname(rs.getString("tname"));
			t.setNumber(rs.getInt("number"));
			list.add(t);
		}
		return list;
	}

}
