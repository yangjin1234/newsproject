package web.core;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;

public class DispatcherAction extends Action{

	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		ActionForward actionforward=null;
		if(af!=null){
			String method=af.getParam();
			if(method==null){
				method="unknown";
			}
				Class c=this.getClass();
				try {
					Method m=c.getMethod(method, new Class[]{HttpServletRequest.class,HttpServletResponse.class,ActionForm.class});
					actionforward=(ActionForward) m.invoke(this, new Object[]{request,response,af});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
			
		}
		return actionforward;
	}
	/**
	 * 未找到param时使用的方法
	 * @param request
	 * @param response
	 * @param af
	 * @return
	 */
	public ActionForward unknown(HttpServletRequest request,
			HttpServletResponse response, ActionForm af){
		System.out.println("unknown");
		return null;
		
	}

}
