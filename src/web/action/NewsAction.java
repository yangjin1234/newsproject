package web.action;

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
import web.form.NewsForm;

public class NewsAction extends DispatcherAction{

	@Override
	public ActionForward execute(HttpServletRequest request,
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
		return null;
	}
}
