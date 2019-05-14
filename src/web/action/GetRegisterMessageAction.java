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
	    //得到注册的用户名及密码
	    String password= user.getUser_pwd1();
	    String uname=user.getUsername();
	    MyLog.log.debug("password=="+password);
	    Connection conn=DBHelper.getConnection();
	    MyLog.log.debug("qqwes");
	    UserDao u=new UserDaoImpl();
	    try {
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
	    if(uid_lid_key!=0)
	    {
				f="true";
				
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
			if("true".equals(f))
			{
				MyLog.log.debug("跳转到了登陆页面");
				return new ActionForward("loginsuccess");
			}
			else{
			return null;
                  }
			}
}
