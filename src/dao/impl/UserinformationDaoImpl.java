package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserinformationDao;
import pojo.impl.Userinformation;

public class UserinformationDaoImpl implements UserinformationDao{

	public int deleteUser(int uid, Connection conn) throws Exception {
		String sql="delete from user where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, uid);
		int count =ps.executeUpdate();
		if(count>0){
			return 0;
		}
		return 1;
	}

	public boolean saveUser(Userinformation user, Connection conn) throws Exception {
		String sql="insert into user(uid,uname,usex,uemail,uphone,uphoto,ustate,uproblem,uanswer,uid_lid_key,uid_sid_key) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		ps.setString(2, user.getUname());
		ps.setString(3, user.getUsex());
		ps.setString(4, user.getUemail());
		ps.setString(5, user.getUphone());
		ps.setString(6, user.getUphoto());
		ps.setInt(7, user.getUstate());
		ps.setString(8, user.getUproblem());
		ps.setString(9, user.getUanswer());
		ps.setInt(10, user.getUid_lid_key());
		ps.setInt(11, user.getUid_sid_key());
		int result=ps.executeUpdate();
		if(result>0){
			return true;
		}
			
		return false;
	}

	public Userinformation selectUserByName(String uname, Connection conn)
			throws Exception {
		String sql="select * from user where uname=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs=ps.executeQuery();
		Userinformation user=null;
		if(rs.next()){
			user = new Userinformation();
			user.setUid(rs.getInt("uid"));
			user.setUname(rs.getString("uname"));
			user.setUsex(rs.getString("usex"));
			user.setUemail(rs.getString("uemail"));
			user.setUphone(rs.getString("uphone"));
			user.setUphoto(rs.getString("uphoto"));
			user.setUstate(rs.getInt("ustate"));
		}
		return user;
	}

	public List<Userinformation> selectUserByState(int ustate, Connection conn)
			throws Exception {
		String sql="select * from user where ustate=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, ustate);
		ResultSet rs=ps.executeQuery();
		List<Userinformation> list=new ArrayList<Userinformation>();
		while(rs.next()){
			Userinformation user = new Userinformation();
			user.setUstate(rs.getInt("ustate"));
			user.setUid(rs.getInt("uid"));
			user.setUname(rs.getString("uname"));
			user.setUsex(rs.getString("usex"));
			user.setUemail(rs.getString("uemail"));
			user.setUphone(rs.getString("uphone"));
			user.setUphoto(rs.getString("uphoto"));
			list.add(user);
		}
		return list;
	}

	public boolean updateUser(Userinformation user, Connection conn) throws Exception {
		String sql="update user set uname=?,usex=?,uemail=?,uphone=?,uphoto=? where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUsex());
		ps.setString(3, user.getUemail());
		ps.setString(4, user.getUphone());
		ps.setString(5, user.getUphoto());
		ps.setInt(6, user.getUid());
		int count = ps.executeUpdate();
		if(count>0){
				return true;
		}else{
		return false;
		}
	}
	
	public int selectUserId(int loginId,Connection conn)throws Exception
	{
		 String sql="select  *from user where uid_lid_key=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, loginId);
		  ResultSet rs=null;
		  int userId=0;
		  try {
			  rs=ps.executeQuery();
			  while(rs.next())
			  {
				  userId=rs.getInt("uid");
				  return userId;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return userId;
	  }
	}



