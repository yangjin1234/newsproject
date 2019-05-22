package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.UserSalaryDao;
import dao.impl.AdminDaoImpl;
import dao.impl.UserSalaryImpl;
import db.DBHelper;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.AdminCheckForm;
import web.form.AdminSalaryStateForm;
import web.form.GetRegisterMessageForm;

public class AdminCheckAction extends DispatcherAction{
//审核通过
public ActionForward checkPath(HttpServletRequest request,
		HttpServletResponse response, ActionForm af) {
	AdminCheckForm ge= (AdminCheckForm)af;
	String data=ge.getData();
	MyLog.log.debug("datastate1=="+data);
	int sid=Integer.parseInt(data);
	MyLog.log.debug("datastate2=="+data);
	//更改工资状态
	AdminDao ad=new AdminDaoImpl();
	Connection conn=DBHelper.getConnection();
	String f="";
	try {
		boolean flag=ad.updateAdminCheckState(sid, conn, 1);
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

//审核不通过
public ActionForward checkNot(HttpServletRequest request,
		HttpServletResponse response, ActionForm af) {
	AdminCheckForm ge= (AdminCheckForm)af;
	String data=ge.getData();
	MyLog.log.debug("datastate1=="+data);
	int sid=Integer.parseInt(data);
	MyLog.log.debug("datastate2=="+data);
	//更改工资状态
	AdminDao ad=new AdminDaoImpl();
	Connection conn=DBHelper.getConnection();
	String f="";
	try {
		boolean flag=ad.updateAdminCheckState(sid, conn, 2);
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
