package web.core;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;

public class ActionForward {
	
	private boolean flag;//是跳转还是重定向
	private String path;
	public ActionForward(String path) {
		this(false,path);
	}
	public ActionForward(boolean flag,String path) {
		this.flag = flag;
		this.path = path;
	}
	public void forward(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		MyLog.log.debug("我进入了注册成功转登陆页面");
		//从应用程序中拿出配置文件
		MyLog.log.debug("path=="+path);
		Properties config = (Properties)request.getSession().getServletContext().getAttribute("config");
		//通过action传过来的路径的key，找到要跳转的页面
		String p = config.get(path).toString();
		MyLog.log.debug("p=="+p);
		if(flag){
			MyLog.log.debug("重定向p"+p);
			response.sendRedirect(p);
		}else{
			MyLog.log.debug("转发p"+p);
			request.getRequestDispatcher(p).forward(request, response);
			
		}
	}
}
