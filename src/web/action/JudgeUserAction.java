package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.JudgeUserForm;
import web.form.UserForm;

public class JudgeUserAction extends DispatcherAction{
	
	public ActionForward judgeUser(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		MyLog.log.debug("judgeuser");
		JudgeUserForm juf=(JudgeUserForm) af;
		MyLog.log.debug(juf);
		return null;
	}
}

