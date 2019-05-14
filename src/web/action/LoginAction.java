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
		String sentence="";
		if(l.getLname()==""){
				sentence+="用户名不能为空"+"\n";
		}
		if(l.getLpass()==""){
			sentence+="密码不能为空"+"\n";
		}
		if(l.getLname()!=""&&l.getLpass()!=""){
			int state=ls.Login(l.getLname(), l.getLpass());
			response.setCharacterEncoding("UTF-8");
			if(state==1){
				return new ActionForward("show");
			}
			else if(state==0){
				sentence+="用户名错误"+"\n";
			}else{
				sentence+="密码错误"+"\n";
			}
		}
		try {
			PrintWriter out=response.getWriter();
			MyLog.log.debug("statea="+sentence);
			out.write(sentence);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
