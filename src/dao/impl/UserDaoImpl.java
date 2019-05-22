package dao.impl;

import java.sql.Connection;
/*
 * 对注册信息的操作
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import pojo.SalaryTable;
import pojo.UpdatePass;
import pojo.User;
import pojo.impl.NewsImpl;
import pojo.impl.Userinformation;
import util.GetDate;
import util.MyLog;
import util.creatkey;
import dao.UserDao;
/*
 * 将注册信息保存到用户表中
 */
public class UserDaoImpl implements UserDao{
	 public int insertRegisterMessage(User u,Connection conn) throws Exception
	    {
		    MyLog.log.debug("进入查询方法了");
		    int  uid_lid_key =creatkey.getCeartKey(); 
		    MyLog.log.debug("uid_lid_key==="+uid_lid_key);
		    int uid=creatkey.getCeartKey();
		    MyLog.log.debug("uid==="+uid);
		    int uid_sid_key=creatkey.getCeartKey();
		    MyLog.log.debug("uid_sid_key==="+uid_sid_key);
		    String uname=u.getUsername();
		    MyLog.log.debug("uname==="+uname);
		    String uemail=u.getUser_email();
		    String uquestion=u.getUser_question();
		    String uanswer=u.getUser_answer();
	    	String sql="insert into user(uid_lid_key,uid,uid_sid_key,uname,uemail,uproblem,uanswer) value(?,?,?,?,?,?,?)";
	    	PreparedStatement ps=conn.prepareStatement(sql);
	    	ps.setInt(1,uid_lid_key);
	    	ps.setInt(2,uid);
	    	ps.setInt(3,uid_sid_key );
	    	ps.setString(4, uname);
	    	ps.setString(5, uemail);
	    	ps.setString(6, uquestion);
	    	ps.setString(7, uanswer);
	    	int result=ps.executeUpdate();
	    	if(result>0)
	    	{
	    		MyLog.log.debug("查询");
	    		MyLog.log.debug("插入注册信息成功");
	    		return uid_lid_key;
	    	}
	    	return 0;	
	    }
	 /*
	  * 根据忘记密码，查询回答问题是否正确
	  */

	 
	 public int selectUserMessage(UpdatePass d,Connection conn) throws Exception
		{
			System.out.println("conn"+conn);
			String sql="select *from user where uname=? ";
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
				String uproblem=rs.getString("uproblem");
				MyLog.log.debug("数据库的uproblem=="+uproblem);
				String uanswer=rs.getString("uanswer");
				MyLog.log.debug("数据库的uproblem=="+uanswer);
				if(user_answer.equals(uanswer)&&user_question.equals(uproblem))
				{
					int uid=rs.getInt("uid_lid_key");
					MyLog.log.debug("用户输入的与数据库的一致");
					return uid;
				}
				else
				{
					MyLog.log.debug("用户输入的与数据库的不一致");
					return 0;
				}
			}
			MyLog.log.debug("查询失败");
			return 0;
		}


	public List<User> selectAllUser(Connection conn) throws Exception {
		String sql="select * from user ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<User> list=new ArrayList<User>();
		while(rs.next()){
			User u=new User();
			u.setUsername(rs.getString("uname"));
			list.add(u);
		}
		return list;
	}
	 
	
	public List<Userinformation> selectAllUser( Connection conn,int pageNo, int pageSize) throws Exception {
		List<NewsImpl> list=new ArrayList<NewsImpl>();
		  String sql="select * from user limit ?,?";
		  PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, (pageNo-1)*pageSize);
		  ps.setInt(2, pageSize);
		  rs=ps.executeQuery();
		  List<Userinformation> l=new ArrayList<Userinformation>();
		  while(rs.next())
		  {
			  Userinformation n=new Userinformation();
			  n.setUanswer(rs.getString("uanswer"));
			  n.setUemail(rs.getString("uemail"));
			  n.setUid(rs.getInt("uid"));
			  n.setUid_lid_key(rs.getInt("uid_lid_key"));
			  n.setUid_sid_key(rs.getInt("uid_sid_key"));
			  n.setUname(rs.getString("uname"));
			  n.setUphone(rs.getString("uphone"));
			  n.setUphoto(rs.getString("uphoto"));
			  n.setUproblem(rs.getString("uproblem"));
			  n.setUsex(rs.getString("usex"));
			  n.setUstate(rs.getInt("ustate"));
			  System.out.println("查询成功");
			  l.add(n);
		  }
		  return l;
	}
	
	
	
	
	
	public int getUserMaxPage(Connection conn,int pageSize) throws Exception
	 {
		 MyLog.log.debug("得到最大页数");
		 String sql="select count(*) as max from user ";
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ResultSet rs=null;
		 int count=0;
		 try {
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 count=rs.getInt("max");
				 MyLog.log.debug("count=="+count);
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return count%pageSize==0?count/pageSize:count/pageSize+1;
	 }
 
 
 public int selectUserCount(Connection conn) throws Exception
	{
	    MyLog.log.debug("用户人数");
		
		String sql="select count(*) as number from user ";
		 PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  rs=ps.executeQuery();
		   int count=0;
			  if(rs.next()){
				  count=rs.getInt("number");
				  MyLog.log.debug("该用户已通过审核的新闻数为"+count);
			  }
			return count;
	}	
	
	 
}
