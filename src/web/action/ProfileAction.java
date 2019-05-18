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
		String nickname=request.getParameter("nickname");
		MyLog.log.debug("nickname="+nickname);
		MyLog.log.debug("nickname="+nickname);
		request.getSession().setAttribute("nickname", nickname);
		return new ActionForward("profile");
	}

}
