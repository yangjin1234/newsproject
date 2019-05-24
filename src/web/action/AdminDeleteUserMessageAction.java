package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserinformationDao;
import dao.impl.UserinformationDaoImpl;
import db.DBHelper;
import pojo.impl.Userinformation;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.AdminDeleteUserMessageForm;
import web.form.AdminSalaryStateForm;

public class AdminDeleteUserMessageAction extends Action{
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		
		DBHelper db=new DBHelper();
		Connection conn=db.getConnection();
		AdminDeleteUserMessageForm ge= (AdminDeleteUserMessageForm)af;
		String data=ge.getData();
		MyLog.log.debug("得到删除用户的uid=="+data);
		//得到用户主键
		int uid=Integer.parseInt(data);
		//得到用户是否被删除的状态
		UserinformationDao information=new UserinformationDaoImpl();
		String f="";
		try {
			int deletestate=information.deleteUser(uid, conn);
			if(deletestate==0)
			{
				f="true";
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
		}finally{
			DBHelper.closeCon(conn);
		}
		return null;
	}

}
