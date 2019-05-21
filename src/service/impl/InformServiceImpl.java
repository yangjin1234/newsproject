package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.InformDao;
import dao.impl.InformDaoImpl;
import db.DBHelper;
import pojo.Inform;
import service.InformService;

public class InformServiceImpl implements InformService{

	private InformDao dao=new InformDaoImpl();
	public List<Inform> selectInform() {
			Connection conn=DBHelper.getConnection();
			List<Inform> list=new ArrayList<Inform>();
			try {
				conn.setAutoCommit(false);
				list= dao.selectInform(conn);
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
			return list;
		}
}
