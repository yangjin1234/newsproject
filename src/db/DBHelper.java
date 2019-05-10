package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBHelper {
	private static DataSource ds=null;
	static{
		try{
			ds=(DataSource)new InitialContext().lookup("java:comp/env/mysql");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void closeCon(Connection conn){
		try{
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection conn=DBHelper.getConnection();
		System.out.println(conn);
		DBHelper.closeCon(conn);
	}

}
