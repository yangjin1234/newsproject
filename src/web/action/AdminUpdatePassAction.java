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
import dao.LoginDao;
import dao.UserDao;
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
	    MyLog.log.debug("pass=="+pass);
	    pass=MyMD5.encrypt(pass);
	    Connection conn=DBHelper.getConnection();
	    UserDao u=new UserDaoImpl();
	    int uid_lid_key=0;
	    try {
			uid_lid_key=u.selectUserMessage(up, conn);
			MyLog.log.debug("uid_lid_key=="+uid_lid_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    String f="";
	    if(uid_lid_key!=0)
	    {
				f="true";
				try {
					LoginDao ld=new LoginDaoImpl();
					boolean flag=ld.updateNewpass(uid_lid_key, pass, conn);
					MyLog.log.debug("flag=="+flag);
					if(flag)
					{
					MyLog.log.debug("插入新密码成功==");
					}
					else
					{
					MyLog.log.debug("插入新密码失败==");
					flag=false;
					}
				} catch (Exception e) {
					e.printStackTrace();
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
