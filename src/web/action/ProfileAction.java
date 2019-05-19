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
		//得到登录用户
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
				Userinformation user=new Userinformation();
				user.setUname(uname);
				user.setUsex(usex);
				user.setUemail(uemail);
				user.setUphone(uphone);
				user.setUphoto(uphoto);
				UserInformationService useris=new UserInformationServiceImpl();
				boolean flag=useris.updateUser(user);
				MyLog.log.debug("flag="+flag);
				request.getSession().setAttribute("uname", user.getUname());
				request.getSession().setAttribute("uemail", user.getUemail());
				request.getSession().setAttribute("umobile", user.getUphone());
				request.getSession().setAttribute("uphoto", user.getUphoto());
				return new ActionForward("profileweb");
	}

}
