package web.action;

import java.io.FileOutputStream;
import java.util.Date;

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
import web.core.DispatcherAction;


public class ProfileAction extends DispatcherAction{

	public ActionForward selectUser(HttpServletRequest request,
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
				 request.getSession().setAttribute("usex", usex);
				 MyLog.log.debug("user_sex="+usex);
				request.getSession().setAttribute("uname", uname);
				request.getSession().setAttribute("uemail", uemail);
				request.getSession().setAttribute("uphone", uphone);
				request.getSession().setAttribute("uphoto", uphoto);
				return new ActionForward("profileweb");
	}
	public ActionForward updateUser(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		//上传修改信息
//		String uphoto = request.getParameter("photo");
//		uphoto = uphoto.substring(uphoto.indexOf(",")+1);
//		BASE64Decoder bd = new BASE64Decoder();
//		byte[] b = bd.decodeBuffer(uphoto);
//		String path = request.getSession().getServletContext().getRealPath("/")+"upload/"+new Date().getTime()+".jpg";
//		FileOutputStream fos = new FileOutputStream(path);
//		fos.write(b);
//		fos.flush();
//		fos.close();
		String uname=request.getParameter("user_name");
		MyLog.log.debug("user_name="+uname);
		String usex=request.getParameter("user_sex");
		MyLog.log.debug("user_sex="+usex);
		String uemail=request.getParameter("email");
		String uphone=request.getParameter("mobile");
		String uphoto=request.getParameter("photo");
		UserInformationService uis=new UserInformationServiceImpl();
		Userinformation user1=uis.selectUserByName(uname);
		Userinformation user=new Userinformation();
		user.setUname(uname);
		user.setUsex(usex);
		user.setUemail(uemail);
		user.setUphone(uphone);
		user.setUphoto(uphoto);
		user.setUid(user1.getUid());
		UserInformationService useris=new UserInformationServiceImpl();
		boolean flag=useris.updateUser(user);
		MyLog.log.debug("flag="+flag);
		request.getSession().setAttribute("uname", user.getUname());
		request.getSession().setAttribute("usex", user.getUsex());
		request.getSession().setAttribute("uemail", user.getUemail());
		request.getSession().setAttribute("uphone", user.getUphone());
		request.getSession().setAttribute("uphoto", user.getUphoto());
		return new ActionForward("profileweb");
	}

}
