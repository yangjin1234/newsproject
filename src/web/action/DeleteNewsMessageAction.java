package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import pojo.Login;
import pojo.News;
import pojo.User;
import dao.LoginDao;
import dao.NewsDao;
import dao.UserDao;
import dao.impl.LoginDaoImpl;
import dao.impl.NewsDaoImpl;
import dao.impl.UserDaoImpl;
import db.DBHelper;
import util.MyLog;
import util.MyMD5;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.DeleteNewsMessageForm;
import web.form.GetRegisterMessageForm;
/**
 * É¾³ýÎÄÕÂµÄActionServlet
 * @author ÒäÐ¦ÈÝÒÀ¾É
 *
 */


public class DeleteNewsMessageAction extends Action{
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		
		
		DeleteNewsMessageForm ge= (DeleteNewsMessageForm)af;
		MyLog.log.debug("ge=="+ge);
		String data=ge.getData();
		String str[]=data.split(",");
		int l=str.length;
		int count=0;
	    Connection conn=DBHelper.getConnection();
	    MyLog.log.debug("conn=="+conn);
	    NewsDao u=new NewsDaoImpl();
	    int nid;
	    boolean flag=false;
	    for (String string : str) {
			MyLog.log.debug("datavalue=="+string);
			nid=Integer.parseInt(string);
			count++;
			MyLog.log.debug("É¾³ýÒ»ÆªÎÄÕÂ³É¹¦");
			try {
				u.deleteNews(nid, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    if(l==count)
	    {
	    	flag=true;
	    }
	    else
	    {
	    	flag=false;
	    }
	    String f="";
	    if(flag)
	    {
				f="true";
				
		}
		else
		{
				f="false";
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
