package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dao.UserDao;
import dao.impl.LoginDaoImpl;
import dao.impl.UserDaoImpl;
import db.DBHelper;
import pojo.Login;
import pojo.User;
import net.sf.json.JSONObject;
import util.MyLog;
import util.MyMD5;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.GetRegisterMessageForm;

public class GetRegisterMessageAction extends Action{
	
	     int uid_lid_key;
public ActionForward execute(HttpServletRequest request,
		HttpServletResponse response, ActionForm af) {
	   
		GetRegisterMessageForm ge= (GetRegisterMessageForm)af;
		MyLog.log.debug("ge=="+ge);
		String data=ge.getData();
		MyLog.log.debug("data=="+data);
	    JSONObject ob=JSONObject.fromObject(data);
	    User user=(User)JSONObject.toBean(ob, User.class);
	    //得到注册的用户名及密码,为了存入登录表
	    String password= user.getUser_pwd1();
	    String uname=user.getUsername();
	    MyLog.log.debug("password=="+password);
	    //得到用户输入的验证码
	    String usercode=user.getUser_code();
	    //得到验证码
	    String code=(String)request.getSession().getAttribute("code");
	    Connection conn=DBHelper.getConnection();
	    MyLog.log.debug("qqwes");
	    UserDao u=new UserDaoImpl();
	    try {
	    	//根据注册的信息，存入用户表中，并将用户表中得到的登录主键，存入登录表
			uid_lid_key=u.insertRegisterMessage(user, conn);
			//对密码进行加密，然后将用户名和密码、主键传入登陆表
			MyLog.log.debug("userm=="+uname);
//			String passwordencode=MyMD5.encrypt(password);
//			MyLog.log.debug("passwordencode=="+passwordencode);
			Login login =new Login();
			login.setLid(uid_lid_key);
			login.setLname(uname);
			login.setLpass(MyMD5.encrypt(password));
			LoginDao ld=new LoginDaoImpl();
			ld.saveLogin(login, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    String f="";
	    //通过用户输入的验证码，判断是否与验证码一致,并判断是否插入信息成功
	    if(uid_lid_key!=0)
	    {
	    	if(code.equals(usercode))
			{
	    		f="true";
			}
	    	else
	    	{
	    		f="error";
	    	}
				
		}
		else
		{
				f="false";
		}
			MyLog.log.debug("uid_lid_key=="+uid_lid_key);
			PrintWriter pw;
			try {
				pw=response.getWriter();
				pw.write(f);
				MyLog.log.debug("f=="+f);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
			}
}
