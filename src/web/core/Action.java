package web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Action {

	public abstract ActionForward execute(HttpServletRequest request,HttpServletResponse response,ActionForm af);
}
