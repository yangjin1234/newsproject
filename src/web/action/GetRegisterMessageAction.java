package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import db.DBHelper;
import pojo.User;
import net.sf.json.JSONObject;
import util.MyLog;
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
	    String userm=user.toString();
	    MyLog.log.debug("userm=="+userm);
	    Connection conn=DBHelper.getConnection();
	    MyLog.log.debug("qqwes");
	    
	    UserDao u=new UserDaoImpl();
	    try {
			uid_lid_key=u.insertRegisterMessage(user, conn);
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
	return new ActionForward("loginshow");
}
}
