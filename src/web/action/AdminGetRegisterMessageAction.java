package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.LoginDao;
import dao.UserDao;
import dao.impl.AdminDaoImpl;
import dao.impl.LoginDaoImpl;
import dao.impl.UserDaoImpl;
import db.DBHelper;
import pojo.Login;
import pojo.User;
import pojo.impl.AdminImpl;
import net.sf.json.JSONObject;
import util.MyLog;
import util.MyMD5;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.AdminGetRegisterMessageForm;
import web.form.GetRegisterMessageForm;

public class AdminGetRegisterMessageAction extends Action{
	
public ActionForward execute(HttpServletRequest request,
		HttpServletResponse response, ActionForm af) {
	   
		AdminGetRegisterMessageForm ge= (AdminGetRegisterMessageForm)af;
		MyLog.log.debug("ge=="+ge);
		String data=ge.getData();
		MyLog.log.debug("data=="+data);
	    JSONObject ob=JSONObject.fromObject(data);
	    AdminImpl user=(AdminImpl)JSONObject.toBean(ob, AdminImpl.class);
	    //�õ��û��������֤��
	    String usercode=user.getUser_code();
	    //�õ�ͼƬ��֤��
	    String code=(String)request.getSession().getAttribute("code");
	    MyLog.log.debug("codeͼƬ��֤��==="+code);
	    Connection conn=DBHelper.getConnection();
	    AdminDao u=new AdminDaoImpl();
	    String f="";
	    try {
	    	//����ע�����Ϣ������admin��
			boolean flag=u.insertRegisterMessage(user, conn);
			if(flag)
			{
				//ͨ���û��������֤�룬�ж��Ƿ�����֤��һ��,���ж��Ƿ������Ϣ�ɹ�
				if(code.equals(usercode))
				{
					f="true";
				}
				else
				{
					f="error";
				}
				
			}
			else
			{
				f="false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			PrintWriter pw;
			try {
				pw=response.getWriter();
				pw.write(f);
				MyLog.log.debug("f=="+f);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
			}
}
