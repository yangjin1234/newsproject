package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.LoginDao;
import pojo.Login;
import util.MyLog;
import util.MyMD5;

public class LoginDaoImpl implements LoginDao{

	public int Login(String lname, String lpass, Connection conn)
			throws Exception {
		String sql="select lpass from login where lname=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, lname);
		ResultSet rs=ps.executeQuery();
		String upassword="";
		if(rs.next()){
			 upassword=rs.getString("lpass");//数据库中
			 MyLog.log.debug("输入的密码="+lpass);
			 MyLog.log.debug("输入的密码加密后="+MyMD5.encrypt(lpass));
			 MyLog.log.debug("数据库中的密码="+upassword);
		}
		if(upassword.equals("")){
			return 0;//无此账号
		}
		if(upassword.equals(MyMD5.encrypt(MyMD5.encrypt(lpass)))){
			return 1;//登录成功
		}
		else{
			return 2;//密码错误
		}
		
	}

	public boolean selectUserByName(String lname, Connection conn)
			throws Exception {
		String sql="select * from login where lname=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, lname);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			MyLog.log.debug("resultset");
			return true;
		}
		   return false;
		
	}

	public Login selectUserPassByName(String lname, Connection conn)
	throws Exception {
		String sql="select * from login where lname=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, lname);
		ResultSet rs=ps.executeQuery();
		Login login=new Login();
		if(rs.next()){
		login.setLid(rs.getInt("lid"));
		login.setLname(rs.getString("lname"));
		login.setLpass(MyMD5.decode(rs.getString("lpass")));
		MyLog.log.debug(MyMD5.decode(rs.getString("lpass")));
		login.setLstate(rs.getInt("lstate"));
		return login;
		}
		return null;
	}
	public boolean updatePass(String lname, String newpass,
			Connection conn) throws Exception {
		String sql="update login set lpass=? where lname=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, MyMD5.encrypt(newpass));
		ps.setString(2, lname);
		int n=ps.executeUpdate();
		Login login=null;
		if(n!=0){
			login=new Login();
			login.setLpass(newpass);
			return true;
		}
		return false;
	}

	public boolean saveLogin(Login login, Connection conn)
			throws Exception {
		String sql="insert into login(lid,lname,lpass) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, login.getLid());
		ps.setString(2, login.getLname());
		ps.setString(3, MyMD5.encrypt(login.getLpass()));
		int result=ps.executeUpdate();
		MyLog.log.debug("加密前="+login.getLpass());
		MyLog.log.debug("加密后="+MyMD5.encrypt(login.getLpass()));
		if(result>0){
			MyLog.log.debug("保存注册信息成功");
			return true;
		}
			
		return false;
	}
	/*
	  * 根据用户输入的新密码更改原来的密码
	  */
	 
	 public boolean updateNewpass(int uid_lid_key,String pass,Connection conn) throws Exception
	    {
		    MyLog.log.debug("进入修改密码方法");
	    	String sql="update  login set lpass=? where lid=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, MyMD5.encrypt(pass));
			ps.setInt(2,uid_lid_key );
			int result=ps.executeUpdate();
			boolean flag=false;
			if(result>0)
			{
				MyLog.log.debug("修改密码成功");
				flag=true;
			    return flag;
			}
			return flag;
	    }

	public pojo.Login selectLoginByUid(int uid, Connection conn)
			throws Exception {
		Login log=new Login();
		String sql="select * from user where uid =?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,uid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			log.setLid(rs.getInt("uid_lid_key"));
		}
		return log;
	}
	

}
