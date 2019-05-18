package web.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;

public class ActionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ActionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获得servlet
		String uri=request.getRequestURI();
		int a=uri.lastIndexOf("/");
		int b=uri.indexOf(".");
		uri=uri.substring(a+1, b);
		
		//拿到配置文件值
		Properties config=(Properties) this.getServletContext().getAttribute("config");
		MyLog.log.debug("uri="+uri);
		MyLog.log.debug("config="+config);
		String key=config.getProperty(uri);
		MyLog.log.debug("keyr="+key);
		
		//拿到action池
		Properties actionPool=(Properties) this.getServletContext().getAttribute("actionPool");
		//form父类
		ActionForm actionform=null;
		String formName=uri+"Form";
		if(config.containsKey(formName)){
			//反射出action类对象
			Class f=null;
			try {
				f = Class.forName(config.get(formName).toString());
				actionform=(ActionForm) f.newInstance();
				MyLog.log.debug("f="+f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 //获得请求的参数
			 Map<String, String[]> map=request.getParameterMap();
			 MyLog.log.debug("parameterMap="+request.getParameter("first"));
			 MyLog.log.debug("map"+map==null);
			 Set<Map.Entry<String, String[]>> set=map.entrySet();
			 MyLog.log.debug("set"+set==null);
			 for (Map.Entry<String, String[]> entry : set) {
				 //获取参数名字
				String keym=entry.getKey();
				String methodName = "set"+keym.substring(0, 1).toUpperCase()+keym.substring(1);
				//反射调用方法
				Method m;
				try {
					m = f.getMethod(methodName, new Class[]{String.class});
					m.invoke(actionform, entry.getValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
			
		}
		
		
		//查看池子中有没有该实列
		Action action=null;
		if(actionPool.get(uri)==null){
			
			//反射出处理类
			try {
				Class c=Class.forName(key);
				 action=(Action)c.newInstance();
				 MyLog.log.debug("action="+action);
				actionPool.put(uri, action);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//有该实列
			 action=(Action) actionPool.get(uri);
		}
		
		
		
		ActionForward af=action.execute(request, response,actionform);
		if(af==null){
		}else{
			//有返回值则跳转
			af.forward(request, response);
			
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		//拿到配置文件路径
				String path=this.getServletContext().getRealPath("/")+this.getServletConfig().getInitParameter("config");
				Properties config=new Properties();
				try {
					config.load(new FileReader(path));
					this.getServletContext().setAttribute("config", config);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Properties actionPool=new Properties();
				this.getServletContext().setAttribute("actionPool", actionPool);
	}

}
