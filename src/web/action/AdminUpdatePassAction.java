package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import pojo.Login;
import pojo.UpdatePass;
import pojo.User;
import dao.AdminDao;
import dao.LoginDao;
import dao.UserDao;
import dao.impl.AdminDaoImpl;
import dao.impl.LoginDaoImpl;
import dao.impl.UserDaoImpl;
import db.DBHelper;
import util.MyLog;
import util.MyMD5;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.AdminUpdatePassForm;
import web.form.GetRegisterMessageForm;
import web.form.UpdatePassForm;

public class AdminUpdatePassAction extends Action{
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		
		AdminUpdatePassForm usf= (AdminUpdatePassForm)af;
		MyLog.log.debug("ge=="+usf);
		String data=usf.getData();
		MyLog.log.debug("data=="+data);
	    JSONObject ob=JSONObject.fromObject(data);
	    UpdatePass up=(UpdatePass)JSONObject.toBean(ob, UpdatePass.class);
	    MyLog.log.debug("username=="+up.getUsername());
	    String pass=up.getUser_pwd1();
	    String aname=up.getUsername();
	    MyLog.log.debug("pass=="+pass);
	    pass=MyMD5.encrypt(pass);
	    Connection conn=DBHelper.getConnection();
	    String f="";
	    AdminDao u=new AdminDaoImpl();
	    try {
			boolean flag=u.updatePass(aname, pass, conn);
			if(flag)
			{
				f="true";
				
				MyLog.log.debug("插入新密码成功==");
				
			}
			else
			{
				f="false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
