package web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSessionFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		Object ob=request.getSession().getAttribute("admin_account");
		if(ob==null){
			request.getRequestDispatcher("./admin_login.jsp").forward(request, response);
		}else{
			arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void autoJump(HttpServletRequest request, HttpServletResponse response,String message)
			throws ServletException, IOException{
		response.setHeader("Refresh", "1;URL=/Newsproject/login.jsp");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(message);
		out.println("   ,1秒后自动跳回");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
