package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import pojo.impl.Userinformation;
import service.UserInformationService;
import dao.LoginDao;
import dao.UserinformationDao;
import dao.impl.LoginDaoImpl;
import dao.impl.UserinformationDaoImpl;
import db.DBHelper;

public class UserInformationServiceImpl implements UserInformationService{
	private UserinformationDao dao=new UserinformationDaoImpl();

	public Userinformation selectUserByName(String uname) {
			Connection conn=DBHelper.getConnection();
			Userinformation uid=new Userinformation();
			try {
				conn.setAutoCommit(false);
				uid=dao.selectUserByName(uname, conn);
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
			return uid;
	}

}
