package web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.ChangeUserEmailForm;

public class AdminChangeUserEmailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		MyLog.log.debug("changeuseremail");
		ChangeUserEmailForm juf=(ChangeUserEmailForm) af;
		MyLog.log.debug(juf);
	    String data=juf.getData();
	    MyLog.log.debug("data=="+data);
	    String reg="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
	    boolean flag=data.matches(reg);
	    String f="";
	    try {
			if(flag)
			{
				MyLog.log.debug("邮箱地址合法");
				f="true";
			}
			else
			{
				MyLog.log.debug("邮箱地址不合法");
				f="false";
			}
			MyLog.log.debug("flag=="+flag);
			MyLog.log.debug("flag=="+flag);
			PrintWriter pw;
			pw=response.getWriter();
			pw.write(f);
			MyLog.log.debug("f=="+f);
			pw.flush();
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return null;
	}

}
