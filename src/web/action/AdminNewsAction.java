package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InformDao;
import dao.NewsDao;
import dao.TypeDao;
import dao.impl.InformDaoImpl;
import dao.impl.NewsDaoImpl;
import dao.impl.TypeDaoImpl;
import db.DBHelper;
import pojo.Inform;
import pojo.Login;
import pojo.News;
import pojo.Type;
import util.GetDate;
import util.MyLog;
import util.creatkey;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.AdminNewsForm;
import web.form.DeleteNewsMessageForm;
import web.form.NewsForm;

public class AdminNewsAction extends DispatcherAction{

	
	public ActionForward insertNews(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		AdminNewsForm nf=(AdminNewsForm) af;
		InformDao id=new InformDaoImpl();
		Connection conn=DBHelper.getConnection();
		String ititle=nf.getNpost_title();//����
		String icontent=nf.getContent();//����
		Inform inform=new Inform();
		inform.setItitle(ititle);
		inform.setIcontent(icontent);
		
		try {
			boolean isfalge=id.insertOneInform(conn, inform);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBHelper.closeCon(conn);
		}
		MyLog.log.debug("���淢�ͳɹ�");
	
		return new ActionForward("edit");
	}
	
	public ActionForward updataNews(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		String nids=request.getParameter("nid");
		int nid=Integer.valueOf(nids);
		NewsForm nf=(NewsForm) af;
		NewsDao nd=new NewsDaoImpl();
		TypeDao td=new TypeDaoImpl();
		Connection conn=DBHelper.getConnection();
		String ntitle=nf.getNpost_title();//����
		String typename=nf.getTypename();//����
		String committype=nf.getNpublish();//�ύ���Ϊ���ǲݸ�
		String content=nf.getContent();//����
		Login account= (Login) request.getSession().getAttribute("logf");
		MyLog.log.debug("account="+account.getLid());
		News ns=new News();
		ns.setNamend_time(GetDate.getNowDate2(GetDate.getNowDate()));
		ns.setNid(nid);
		ns.setTitle(ntitle);
		ns.setNid_uid_key(account.getLid());/////
		Type ty=null;
		try {
			ty=td.selectTypeByTname(conn, typename);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ns.setNid_tid_key(ty.getTid());////
		ns.setNcontent(content);
		if(nf.getNpublish()==null){
			ns.setNews_state(1);//��Ϊ�ݸ�
		}
		else{
			ns.setNews_state(2);//�����
		}
		MyLog.log.debug("newsform="+af.toString());
		try {
			nd.updateNews(ns, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.closeCon(conn);
		return new ActionForward("edit");
	}
	public ActionForward removeToRecycle(HttpServletRequest request,
			HttpServletResponse response, ActionForm af){
//
//		
//		
		NewsForm ge= (NewsForm)af;
		String data=ge.getNid();
		MyLog.log.debug("data=="+data);
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
			MyLog.log.debug("ɾ��һƪ���³ɹ�");
			try {
				u.updateNewsState(nid, 3, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBHelper.closeCon(conn);
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
