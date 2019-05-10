package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.UserForm;

public class UserAction extends DispatcherAction {

	public ActionForward register(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		MyLog.log.debug("register");
		UserForm u=(UserForm) af;
		MyLog.log.debug(u);
		return null;
	}
	public ActionForward login(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		MyLog.log.debug("login");
		UserForm u=(UserForm) af;
		MyLog.log.debug(u.getUname());
		MyLog.log.debug(u.getWp_submit());
		MyLog.log.debug(u.getRememberme());
		return null;
	}

}
