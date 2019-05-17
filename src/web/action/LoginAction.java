package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Login;
import pojo.impl.LoginImpl;
import net.sf.json.JSONObject;
import service.LoginService;
import service.impl.LoginServiceImpl;
import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.LoginForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
//		String lname=request.getParameter("lname");
//		String lpass=request.getParameter("lpass");
//		LoginService ls=new LoginServiceImpl();
//		int state=ls.Login(lname, lpass);
//		MyLog.log.debug("state="+state);
//		if(state==1){
//			return new ActionForward("show");
//		}else {
//			return new ActionForward(true,"loginshow");
//		}
		LoginForm loginf=(LoginForm)af;
		JSONObject obj = JSONObject.fromObject(loginf.getData());
		MyLog.log.debug("statea="+obj);
		LoginImpl l=(LoginImpl)JSONObject.toBean(obj,LoginImpl.class);
		LoginService ls=new LoginServiceImpl();
		boolean flag=l.isLrememberme();
		MyLog.log.debug("flag="+flag);
		String sentence="";
		if("".equals(l.getLname())){
				sentence+="用户名不能为空\r\n";
		}
		if("".equals(l.getLpass())){
			sentence+="密码不能为空\r\n";
		}
		if(l.getLname()!=""&&l.getLpass()!=""){
			int state=ls.Login(l.getLname(), l.getLpass());
			response.setCharacterEncoding("UTF-8");
			if(state==1){
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				MyLog.log.debug("statea="+sentence);
				out.write("true");
				out.flush();
				out.close();
				//存Cookie
				if(flag){
					Cookie c1;
					try {
						c1 = new Cookie("lname",URLEncoder.encode(l.getLname(), "UTF-8"));
						c1.setDomain("localhost");
						c1.setPath("/Newsproject");
						c1.setMaxAge(60*60*24);
						MyLog.log.debug("cookie="+c1);
						response.addCookie(c1);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					Cookie c2 = new Cookie("lpass",l.getLpass());
					c2.setDomain("localhost");
					c2.setPath("/Newsproject");
					c2.setMaxAge(60*60*24);
					response.addCookie(c2);
				}
				//从请求中拿到cookie
	    		Cookie[] cookies = request.getCookies();
	    		String valname = null;
	    		String valpass = null;
	    		//循环所有的cookie，得到我需要的数据
	    		if(cookies!=null){
		    		for(Cookie c : cookies){
		    			String key = c.getName();
		    			if("lname".equals(key)){
		    				valname = c.getValue();
		    				//解码
		    				try {
								valname = URLDecoder.decode(valname, "UTF-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
		    			}
		    			if("lpass".equals(key)){
		    				valpass = c.getValue();
		    			}
		    		}
	    		}
				
				request.getSession().setAttribute("account", l);
				return new ActionForward("show");
			}
			else if(state==0){
				sentence+="用户名错误\r\n";
			}else{
				sentence+="密码错误\r\n";
			}
		}
		try {
			PrintWriter out=response.getWriter();
			MyLog.log.debug("statea="+sentence);
			out.write(sentence);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
