package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InformDao;
import dao.impl.InformDaoImpl;
import db.DBHelper;
import pojo.Inform;
import service.InformService;

public class InformServiceImpl implements InformService{

	private InformDao dao=new InformDaoImpl();
	public Inform selectInform() {
			Connection conn=DBHelper.getConnection();
			Inform inform=new Inform();
			try {
				conn.setAutoCommit(false);
				inform=dao.selectInform(conn);
				conn.commit();
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}finally{
				DBHelper.closeCon(conn);
			}
			return inform;
		}
}
