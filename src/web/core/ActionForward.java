package web.core;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionForward {

	private boolean flag;//����ת�����ض���
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
		//��Ӧ�ó������ó������ļ�
		Properties config = (Properties)request.getSession().getServletContext().getAttribute("config");
		//ͨ��action��������·����key���ҵ�Ҫ��ת��ҳ��
		String p = config.get(path).toString();
		if(flag){
			response.sendRedirect(p);
		}else{
			request.getRequestDispatcher(p).forward(request, response);
		}
	}
}