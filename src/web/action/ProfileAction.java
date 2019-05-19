package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;

public class ProfileAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		String uname=request.getParameter("user_name");
		MyLog.log.debug("user_name="+uname);
		String usex=request.getParameter("user_sex");
		MyLog.log.debug("user_sex="+usex);
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		request.getSession().setAttribute("uname", uname);
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("mobile", mobile);
		return new ActionForward("profileweb");
	}

}
