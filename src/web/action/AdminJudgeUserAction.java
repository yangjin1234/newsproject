package web.action;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import dao.AdminDao;
import dao.LoginDao;
import dao.impl.AdminDaoImpl;
import dao.impl.LoginDaoImpl;
import db.DBHelper;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.AdminJudgeUserForm;
import web.form.JudgeUserForm;
import web.form.UserForm;

public class AdminJudgeUserAction extends Action{
	
	public ActionForward execute(HttpServletRequest request,
		HttpServletResponse response, ActionForm af) {
		MyLog.log.debug("judgeuser");
		AdminJudgeUserForm juf=(AdminJudgeUserForm) af;
		Connection conn =DBHelper.getConnection();
		MyLog.log.debug("conn=="+conn);
		MyLog.log.debug(juf);
	    String data=juf.getData();
	    MyLog.log.debug("data=="+data);
	    AdminDao login=new AdminDaoImpl();
	    String f="";
	    try {
			boolean flag=login.selectUserByName(data, conn);
			if(flag)
			{
				f="true";
			}
			else
			{
				f="false";
			}
			MyLog.log.debug("flag=="+flag);
			PrintWriter pw;
			pw=response.getWriter();
			pw.write(f);
			MyLog.log.debug("f=="+f);
			pw.flush();
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return null;
	}
	
}

