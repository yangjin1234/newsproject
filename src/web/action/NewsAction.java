package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.NewsForm;

public class NewsAction extends DispatcherAction{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		NewsForm nf=(NewsForm) af;
		MyLog.log.debug("newsform="+nf.toString());
		return null;
	}
}
