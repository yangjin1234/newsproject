package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.impl.LoginImpl;
import pojo.impl.Userinformation;
import service.UserInformationService;
import service.impl.UserInformationServiceImpl;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;

public class ProfileAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		//�õ���¼�û�
				LoginImpl log=new LoginImpl();
				 log=(LoginImpl)request.getSession().getAttribute("account");
				 String uname=log.getLname();
				 UserInformationService uis=new UserInformationServiceImpl();
				 Userinformation useri=uis.selectUserByName(uname);
				 String usex=useri.getUsex();
				 String uemail=useri.getUemail();
				 String uphone=useri.getUphone();
				 String uphoto=useri.getUphoto();
				 uname=request.getParameter("user_name");
				MyLog.log.debug("user_name="+uname);
				usex=request.getParameter("user_sex");
				MyLog.log.debug("user_sex="+usex);
				uemail=request.getParameter("email");
				uphone=request.getParameter("mobile");
				uphoto=request.getParameter("photo");
				
				request.getSession().setAttribute("uname", uname);
				request.getSession().setAttribute("uemail", uemail);
				request.getSession().setAttribute("umobile", uphone);
				request.getSession().setAttribute("uphoto", uphoto);
				return new ActionForward("profileweb");
	}

}
