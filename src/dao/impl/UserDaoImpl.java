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
		    MyLog.log.debug("�����ѯ������");
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
	    		MyLog.log.debug("��ѯ");
	    		MyLog.log.debug("����ע����Ϣ�ɹ�");
	    		return uid_lid_key;
	    	}
	    	return 0;	
	    }

}
