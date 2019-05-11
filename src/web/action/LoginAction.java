package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import service.impl.LoginServiceImpl;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		String lname=request.getParameter("lname");
		String lpass=request.getParameter("lpass");
		LoginService ls=new LoginServiceImpl();
		int state=ls.Login(lname, lpass);
		MyLog.log.debug("state="+state);
		if(state==1){
			return new ActionForward("show");
		}else {
			return new ActionForward(true,"login");
		}
	}

}
