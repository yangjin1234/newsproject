package dao.impl;

import java.sql.Connection;
/*
 * ��ע����Ϣ�Ĳ���
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import pojo.SalaryTable;
import pojo.UpdatePass;
import pojo.User;
import util.GetDate;
import util.MyLog;
import util.creatkey;
import dao.UserDao;
/*
 * ��ע����Ϣ���浽�û�����
 */
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
	 /*
	  * �����������룬��ѯ�ش������Ƿ���ȷ
	  */

	 
	 public int selectUserMessage(UpdatePass d,Connection conn) throws Exception
		{
			System.out.println("conn"+conn);
			String sql="select *from user where uname=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			String username=d.getUsername();
			String user_answer=d.getUser_answer();
			MyLog.log.debug("�û������uanswer=="+user_answer);
			String  user_question=d.getUser_question();
			MyLog.log.debug("�û������uproblem=="+user_question);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String uproblem=rs.getString("uproblem");
				MyLog.log.debug("���ݿ��uproblem=="+uproblem);
				String uanswer=rs.getString("uanswer");
				MyLog.log.debug("���ݿ��uproblem=="+uanswer);
				if(user_answer.equals(uanswer)&&user_question.equals(uproblem))
				{
					int uid=rs.getInt("uid_lid_key");
					MyLog.log.debug("�û�����������ݿ��һ��");
					return uid;
				}
				else
				{
					MyLog.log.debug("�û�����������ݿ�Ĳ�һ��");
					return 0;
				}
			}
			MyLog.log.debug("��ѯʧ��");
			return 0;
		}
	 
	 
}
