package web.core;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;

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
		MyLog.log.debug("�ҽ�����ע��ɹ�ת��½ҳ��");
		//��Ӧ�ó������ó������ļ�
		MyLog.log.debug("path=="+path);
		Properties config = (Properties)request.getSession().getServletContext().getAttribute("config");
		//ͨ��action��������·����key���ҵ�Ҫ��ת��ҳ��
		String p = config.get(path).toString();
		MyLog.log.debug("p=="+p);
		if(flag){
			MyLog.log.debug("�ض���p"+p);
			response.sendRedirect(p);
		}else{
			MyLog.log.debug("ת��p"+p);
			request.getRequestDispatcher(p).forward(request, response);
			
		}
	}
}
