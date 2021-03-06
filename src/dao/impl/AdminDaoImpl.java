package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Admin;
import pojo.Inform;
import pojo.Login;
import pojo.UpdatePass;
import pojo.impl.AdminImpl;
import util.MyLog;
import util.MyMD5;
import util.creatkey;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao {

	/**
	 * 按用戶名登陸
	 */
	public int Login(String aname, String apass, Connection conn)
			throws Exception {

		String sql = "select * from admin WHERE aname=? and acheck=1";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, aname);
		ResultSet rs = ps.executeQuery();
		String upassword = "";
		MyLog.log.debug("aname=" + aname);
		if (rs.next()) {
			upassword = rs.getString("apass");// 数据库中
			MyLog.log.debug("输入的密码1=" +MyMD5.encrypt(apass));
			MyLog.log.debug("输入的密码2=" +MyMD5.encrypt((MyMD5.encrypt(apass))));
			MyLog.log.debug("输入的密码3=" + MyMD5.encrypt(MyMD5.encrypt((MyMD5.encrypt(apass)))));
			MyLog.log.debug("数据库中的密码=" + upassword);
		}
		if ("".equals(upassword)) {
			return 0;// 无此账号
		}
		if (upassword.equals(MyMD5.encrypt(apass))) {
			return 1;// 登录成功
		} else {
			return 2;// 密码错误
		}
	}

	/**
	 * 管理員注冊
	 */
	public boolean saveLogin(Admin admin, Connection conn)
			throws Exception {

		String sql = "INSERT INTO admin(aid, aname, apass, aphone) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, admin.getAid());
		ps.setString(2, admin.getAname());
		ps.setString(3, MyMD5.encrypt(admin.getApass()));
		MyLog.log.debug("admin.pass="+admin.getApass());
		MyLog.log.debug("admin.pass加密="+MyMD5.encrypt(admin.getApass()));
		ps.setString(4, admin.getAphone());
		int result = ps.executeUpdate();
		if (result > 0) {
			MyLog.log.debug("保存注册信息成功");
			return true;
		}

		return false;
	}

	/**
	 * 通過管理員的名字查詢
	 */
	public boolean selectUserByName(String aname, Connection conn)
			throws Exception {

		String sql = "SELECT * FROM admin WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, aname);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			MyLog.log.debug("resultset");
			return true;
		}
		return false;
	}

	/**
	 * 通過管理員名字查詢密碼
	 */
	public Admin selectUserPassByName(String aname, Connection conn)
			throws Exception {
		
		String sql = "SELECT * FROM admin WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, aname);
		ResultSet rs = ps.executeQuery();
		Admin admin = new Admin();
		if (rs.next()) {
			admin.setAid(rs.getInt("aid"));
			admin.setAname(rs.getString("aname"));
			admin.setApass(MyMD5.decode(rs.getString("apass")));
			admin.setAstate(rs.getInt("astate"));
			admin.setAdmin_type(rs.getInt("admin_type"));//管理员类型
			MyLog.log.debug("admin="+admin.getAname());
			return admin;
		}
		return null;
	}

	/**
	 * 更新密碼
	 */
	public boolean updatePass(String aname, String newpass, Connection conn)
			throws Exception {
		
		String sql = "UPDATE admin SET apass=? WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, MyMD5.encrypt(newpass));
		ps.setString(2, aname);
		int n = ps.executeUpdate();
		Admin admin = null;
		if (n != 0) {
			admin = new Admin();
			admin.setApass(newpass);
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public boolean updateNewpass(int aid_aid_key, String pass, Connection conn)
			throws Exception {
		
		MyLog.log.debug("进入修改密码方法");
		String sql = "UPDATE admin SET apass=? WHERE aid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, MyMD5.encrypt(pass));
		ps.setInt(2, aid_aid_key);
		int result = ps.executeUpdate();
		boolean flag = false;
		if (result > 0) {
			MyLog.log.debug("修改密码成功");
			flag = true;
			return flag;
		}
		return flag;
	}

	public List<Admin> selectAllNotPathAdmin(Connection conn, int pageNo,
			int pageSize) throws Exception {
		String sql="select * from admin where astate=1 and acheck=0 limit ?,?";
		PreparedStatement ps=conn.prepareStatement(sql);
		List<Admin> list=new ArrayList<Admin>();
		 ps.setInt(1, (pageNo-1)*pageSize);
		  ps.setInt(2, pageSize);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Admin admin=new Admin();
			admin.setAid(rs.getInt("aid"));
			admin.setAcheck(rs.getInt("acheck"));
			admin.setAname(rs.getString("aname"));
			admin.setApass(rs.getString("aname"));
			admin.setAphone(rs.getString("aphone"));
			list.add(admin);
		}
		return list;
	}

	public int selectAllNotPathAdminForMaxPage(Connection conn, int pageSize)
			throws Exception {
		 String sql="select count(*) as max from admin where astate=1 and acheck=0";
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

	public int selectAllNotPathAdminSum(Connection conn) throws Exception {
		String sql="select count(*) as max from admin where astate=1 and acheck=0";
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
		  return count;
	}

	public boolean updateAdminCheckState(int aid, Connection conn, int acheck)throws Exception {
		String sql="update admin set acheck=? where aid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, acheck);
		ps.setInt(2, aid);
		int n=ps.executeUpdate();
		if(n>0){
			return true;
		}
		return false;
	}
	
	
	public boolean insertRegisterMessage(AdminImpl u,Connection conn) throws Exception
    {
	    MyLog.log.debug("进入查询方法了");
	    int  aid =creatkey.getCeartKey();
	    
	    MyLog.log.debug("aid==="+aid);
	    String aname=u.getUsername();
	    MyLog.log.debug("uname==="+aname);
	    
	    String aquestion=u.getUser_question();
	    
	    String aanswer=u.getUser_answer();
	    
	    String apass=u.getUser_pwd1();
	    MyLog.log.debug("加密前==="+apass);
	    apass= MyMD5.encrypt(apass);
	    MyLog.log.debug("加密后==="+apass);
    	String sql="insert into admin(aid,aname,apass,aquestion,aanswer) value(?,?,?,?,?)";
    	PreparedStatement ps=conn.prepareStatement(sql);
    	ps.setInt(1,aid);
    	ps.setString(2,aname);
    	ps.setString(3,apass );
    	ps.setString(4, aquestion);
    	ps.setString(5, aanswer);
    	int result=ps.executeUpdate();
    	if(result>0)
    	{
    		MyLog.log.debug("管理员表查询成功");
    		MyLog.log.debug("插入注册信息成功");
    		return true;
    	}
    	return false;	
}
	
	
	
	
	public boolean selectAdminMessage(UpdatePass d,Connection conn) throws Exception
	{
		System.out.println("conn"+conn);
		String sql="select *from admin where aname=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		String username=d.getUsername();
		String user_answer=d.getUser_answer();
		MyLog.log.debug("用户输入的uanswer=="+user_answer);
		String  user_question=d.getUser_question();
		MyLog.log.debug("用户输入的uproblem=="+user_question);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String uproblem=rs.getString("aquestion");
			MyLog.log.debug("数据库的uproblem=="+uproblem);
			String uanswer=rs.getString("aanswer");
			MyLog.log.debug("数据库的uproblem=="+uanswer);
			if(user_answer.equals(uanswer)&&user_question.equals(uproblem))
			{
				
				MyLog.log.debug("管理员输入的与数据库的一致");
				return true;
			}
			else
			{
				MyLog.log.debug("管理员输入的与数据库的不一致");
				return false;
			}
		}
		MyLog.log.debug("查询失败");
		return false;
	}

	public List<Admin> selectAllAdminByAcheck(Connection conn, int pageNo,
			int pageSize, int acheck) throws Exception {
		String sql="select * from admin where astate=1 and acheck=? limit ?,?";
		PreparedStatement ps=conn.prepareStatement(sql);
		List<Admin> list=new ArrayList<Admin>();
		ps.setInt(1, acheck);
		 ps.setInt(2, (pageNo-1)*pageSize);
		  ps.setInt(3, pageSize);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Admin admin=new Admin();
			admin.setAid(rs.getInt("aid"));
			admin.setAcheck(rs.getInt("acheck"));
			admin.setAname(rs.getString("aname"));
			admin.setApass(rs.getString("aname"));
			admin.setAphone(rs.getString("aphone"));
			list.add(admin);
		}
		return list;
	}

	public int selectAllAdminByAcheckForMaxPage(Connection conn, int pageSize,int acheck)
			throws Exception {
		 String sql="select count(*) as max from admin where astate=1 and acheck=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
	      ps.setInt(1, acheck);
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

	public int selectAllAdminByAcheckSum(Connection conn, int acheck)
			throws Exception {
		String sql="select count(*) as max from admin where astate=1 and acheck=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, acheck);
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
		  return count;
	}
	

}
