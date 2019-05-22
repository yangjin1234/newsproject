package web.action;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import db.DBHelper;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.AdminJudgeUserEmailForm;
import web.form.JudgeUserEmailForm;
import web.form.JudgeUserForm;

public class AdminJudgeUserEmailAction extends Action{
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
			MyLog.log.debug("judgeuseremail");
			AdminJudgeUserEmailForm juf=(AdminJudgeUserEmailForm) af;
			MyLog.log.debug(juf);
		    String data=juf.getData();
		    MyLog.log.debug("data=="+data);
		    String reg="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		    boolean flag=data.matches(reg);
		    String f="";
		    try {
				if(flag)
				{
					MyLog.log.debug("邮箱地址合法");
					f="true";
				}
				else
				{
					MyLog.log.debug("邮箱地址不合法");
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
