package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.LoginDao;
import pojo.Login;
import pojo.User;
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
			 upassword=rs.getString("lpass");
		}
		if(upassword.equals("")){
			return 0;//无此账号
		}
		if(upassword.equals(lpass)){
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
		login.setLpass(rs.getString("lpass"));
		login.setLstate(rs.getInt("lstate"));
		if(rs==null){
			return null;
		}else{
			return login;
		}
		}
		return null;
	}
	public boolean updatePass(String lname, String newpass,
			Connection conn) throws Exception {
		String sql="update login set lpass=? where lname=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, newpass);
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
		if(result>0){
			MyLog.log.debug("保存注册信息成功");
			return true;
		}
			
		return false;
	}
	

}
