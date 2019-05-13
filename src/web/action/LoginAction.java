package web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Login;
import pojo.impl.LoginImpl;
import net.sf.json.JSONObject;
import service.LoginService;
import service.impl.LoginServiceImpl;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.LoginForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
//		String lname=request.getParameter("lname");
//		String lpass=request.getParameter("lpass");
//		LoginService ls=new LoginServiceImpl();
//		int state=ls.Login(lname, lpass);
//		MyLog.log.debug("state="+state);
//		if(state==1){
//			return new ActionForward("show");
//		}else {
//			return new ActionForward(true,"loginshow");
//		}
		LoginForm loginf=(LoginForm)af;
		JSONObject obj = JSONObject.fromObject(loginf.getData());
		MyLog.log.debug("statea="+obj);
		LoginImpl l=(LoginImpl)JSONObject.toBean(obj,LoginImpl.class);
		LoginService ls=new LoginServiceImpl();
		int state=ls.Login(l.getLname(), l.getLpass());
		response.setCharacterEncoding("UTF-8");
		if(state==1){
			return new ActionForward("show");
		}
		else if(state==0){
			try {
				
				PrintWriter out=response.getWriter();
				out.write("”√ªß√˚¥ÌŒÛ");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}else{
			try {
				PrintWriter out=response.getWriter();
				out.write("√‹¬Î¥ÌŒÛ");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
