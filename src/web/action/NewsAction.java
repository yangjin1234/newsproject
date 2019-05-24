package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import dao.TypeDao;
import dao.impl.NewsDaoImpl;
import dao.impl.TypeDaoImpl;
import db.DBHelper;
import pojo.Login;
import pojo.News;
import pojo.Type;
import util.GetDate;
import util.MyLog;
import util.creatkey;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.DeleteNewsMessageForm;
import web.form.NewsForm;

public class NewsAction extends DispatcherAction{

	
	public ActionForward insertNews(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		NewsForm nf=(NewsForm) af;
		NewsDao nd=new NewsDaoImpl();
		TypeDao td=new TypeDaoImpl();
		Connection conn=DBHelper.getConnection();
		String ntitle=nf.getNpost_title();//标题
		String typename=nf.getTypename();//类型
		String committype=nf.getNpublish();//提交审核为空是草稿
		String content=nf.getContent();//内容
		Login account= (Login) request.getSession().getAttribute("logf");
		MyLog.log.debug("account="+account.getLid());
		int nid=creatkey.getCeartKey();
		News ns=new News();
		ns.setNamend_time(GetDate.getNowDate2(GetDate.getNowDate()));
		ns.setNupload_time(GetDate.getNowDate2(GetDate.getNowDate()));
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
			ns.setNews_state(1);//存为草稿
		}
		else{
			ns.setNews_state(2);//待审核
		}
		MyLog.log.debug("newsform="+af.toString());
		try {
			nd.insertNews(ns, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.closeCon(conn);
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
		String ntitle=nf.getNpost_title();//标题
		String typename=nf.getTypename();//类型
		String committype=nf.getNpublish();//提交审核为空是草稿
		String content=nf.getContent();//内容
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
			ns.setNews_state(1);//存为草稿
		}
		else{
			ns.setNews_state(2);//待审核
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
			MyLog.log.debug("删除一篇文章成功");
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
	
	
	public ActionForward updateNewsCheckPath(HttpServletRequest request,
			HttpServletResponse response, ActionForm af){
		NewsForm ge= (NewsForm)af;
	    Connection conn=DBHelper.getConnection();
	    NewsDao u=new NewsDaoImpl();
				try {
					u.updateNewsState(Integer.valueOf(ge.getNid()), 1, conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  
			return new ActionForward("admin_edit");
	}
	
	public ActionForward updateNewsCheckNo(HttpServletRequest request,
			HttpServletResponse response, ActionForm af){
	NewsForm ge= (NewsForm)af;
	    Connection conn=DBHelper.getConnection();
	    NewsDao u=new NewsDaoImpl();
				try {
					u.updateNewsState(Integer.valueOf(ge.getNid()), 2, conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBHelper.closeCon(conn);
				}
				return new ActionForward("admin_edit");
	}
}
