package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.ejb.CreateException;

import pojo.SalaryTable;
import pojo.User;
import util.GetDate;
import util.MyLog;
import util.creatkey;
import dao.UserDao;

public class UserDaoImpl implements UserDao{
	 public int insertRegisterMessage(User u,Connection conn) throws Exception
	    {
		    int  uid_lid_key =creatkey.getCeartKey(); 
		    int uid=creatkey.getCeartKey();
		    int uid_sid_key=creatkey.getCeartKey();
		    String uname=u.getUname();
		    String uemail=u.getUemail();
		    String uquestion=u.getUquestion();
		    String uanswer=u.getUanwer();
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
	    		MyLog.log.debug("进入查询");
	    		MyLog.log.debug("插入注册信息成功");
	    		return uid_lid_key;
	    	}
	    	return 0;	
	    }

}
