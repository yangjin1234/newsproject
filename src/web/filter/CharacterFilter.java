package web.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter{

	private String oldEncolding="";
	private String newEncolding="";
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		String way=request.getMethod();
		if("GET".equals(way)){
			Collection<String[]> coll=request.getParameterMap().values();
			Iterator<String[]> it=coll.iterator();
			while(it.hasNext()){
				String[] s=it.next();
				for (int i = 0; i < s.length; i++) {
					s[i]=new String(s[i].getBytes(oldEncolding),newEncolding);
				}
			}
		}else{
			request.setCharacterEncoding(newEncolding);
		}
		//response.setCharacterEncoding(newEncolding);
		arg2.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		oldEncolding=arg0.getInitParameter("oldEncolding");
		newEncolding=arg0.getInitParameter("newEncolding");
	}

}
