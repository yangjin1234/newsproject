package web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Login;
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
		MyLog.log.debug("state="+obj);
		Login l=(Login)JSONObject.toBean(obj);
		LoginService ls=new LoginServiceImpl();
		int state=ls.Login(l.getLname(), l.getLpass());
		if(state==1){
			return new ActionForward("show");
		}else {
			JSONObject returnval=JSONObject.fromObject(state);
			try {
				PrintWriter out=response.getWriter();
				out.write(returnval.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
