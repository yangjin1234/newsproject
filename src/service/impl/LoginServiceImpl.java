package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import pojo.Login;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import db.DBHelper;
import service.LoginService;

public class LoginServiceImpl implements LoginService{
	private LoginDao dao=new LoginDaoImpl();
	public int Login(String lname, String lpass) {
		Connection conn=DBHelper.getConnection();
		int login=0;
		try {
			conn.setAutoCommit(false);
			login=dao.Login(lname, lpass, conn);
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
		return 1;
	}

}
