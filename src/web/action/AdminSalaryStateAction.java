package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserSalaryDao;
import dao.impl.UserSalaryImpl;
import db.DBHelper;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.AdminSalaryStateForm;
import web.form.GetRegisterMessageForm;

public class AdminSalaryStateAction extends Action{

public ActionForward execute(HttpServletRequest request,
		HttpServletResponse response, ActionForm af) {
	AdminSalaryStateForm ge= (AdminSalaryStateForm)af;
	String data=ge.getData();
	MyLog.log.debug("datastate1=="+data);
	int sid=Integer.parseInt(data);
	MyLog.log.debug("datastate2=="+data);
	//更改工资状态
	UserSalaryDao sa=new UserSalaryImpl();
	Connection conn=DBHelper.getConnection();
	String f="";
	try {
		boolean flag=sa.updateSalaryState(1, conn, sid);
		if(flag)
		{
			f="true";
		}
		else
		{
			f="false";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBHelper.closeCon(conn);
	}
	
	//返回一个字符串给ajax
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
