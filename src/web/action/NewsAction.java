package web.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import db.DBHelper;
import pojo.News;
import util.GetDate;
import util.MyLog;
import util.creatkey;
import web.core.ActionForm;
import web.core.ActionForward;
import web.core.DispatcherAction;
import web.form.NewsForm;

public class NewsAction extends DispatcherAction{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		NewsForm nf=(NewsForm) af;
		NewsDao nd=new NewsDaoImpl();
		Connection conn=DBHelper.getConnection();
		MyLog.log.debug("newsform="+nf.toString());
		String ntitle=nf.getNpost_title();//标题
		String typename=nf.getTypename();//类型
		String committype=nf.getNpublish();//提交审核为空是草稿
		String content=nf.getContent();//内容
		String userid=(String) request.getSession().getAttribute("account");
		int nid=creatkey.getCeartKey();
		News ns=new News();
		ns.setNamend_time(GetDate.getNowDate2(GetDate.getNowDate()));
		ns.setNupload_time(GetDate.getNowDate2(GetDate.getNowDate()));
		ns.setNid(nid);
		ns.setTitle(ntitle);
		ns.setNid_tid_key(1);////
		ns.setNid_uid_key(1);/////
		ns.setNcontent(content);
		if(committype==null){
			ns.setNews_state(2);//存为草稿
		}
		else{
			ns.setNews_state(3);//待审核
		}
		try {
			nd.insertNews(ns, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.closeCon(conn);
		return null;
	}
}
