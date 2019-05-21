package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.Admin;
import pojo.Login;
import util.MyLog;
import util.MyMD5;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao {

	/**
	 * ���Ñ������
	 */
	public int Login(String aname, String apass, Connection conn)
			throws Exception {

		String sql = "select apass from admin WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, aname);
		ResultSet rs = ps.executeQuery();
		String upassword = "";
		if (rs.next()) {
			upassword = rs.getString("apass");// ���ݿ���
			MyLog.log.debug("���������=" + MyMD5.decode(upassword));
			MyLog.log.debug("���ݿ��е�����=" + upassword);
		}
		if (upassword.equals("")) {
			return 0;// �޴��˺�
		}
		if (upassword.equals(MyMD5.decode(upassword))) {
			return 1;// ��¼�ɹ�
		} else {
			return 2;// �������
		}
	}

	/**
	 * ����Tע��
	 */
	public boolean saveLogin(Admin admin, Connection conn)
			throws Exception {

		String sql = "INSERT INTO admin(aid, aname, apass, aphone) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, admin.getAid());
		ps.setString(2, admin.getAname());
		ps.setString(3, MyMD5.encrypt(admin.getApass()));
		ps.setString(4, admin.getAphone());
		int result = ps.executeUpdate();
		if (result > 0) {
			MyLog.log.debug("����ע����Ϣ�ɹ�");
			return true;
		}

		return false;
	}

	/**
	 * ͨ�^����T�����ֲ�ԃ
	 */
	public boolean selectUserByName(String aname, Connection conn)
			throws Exception {

		String sql = "SELECT * FROM admin WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, aname);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			MyLog.log.debug("resultset");
			return true;
		}
		return false;
	}

	/**
	 * ͨ�^����T���ֲ�ԃ�ܴa
	 */
	public Admin selectUserPassByName(String aname, Connection conn)
			throws Exception {
		
		String sql = "SELECT * FROM admin WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, aname);
		ResultSet rs = ps.executeQuery();
		Admin admin = new Admin();
		if (rs.next()) {
			admin.setAid(rs.getInt("aid"));
			admin.setAname(rs.getString("aname"));
			admin.setApass(MyMD5.decode(rs.getString("apass")));
			admin.setAstate(rs.getInt("astate"));
			if (rs != null) {
				return admin;
			}
		}
		return null;
	}

	/**
	 * �����ܴa
	 */
	public boolean updatePass(String aname, String newpass, Connection conn)
			throws Exception {
		
		String sql = "UPDATE admin SET apass=? WHERE aname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, MyMD5.encrypt(newpass));
		ps.setString(2, aname);
		int n = ps.executeUpdate();
		Admin admin = null;
		if (n != 0) {
			admin = new Admin();
			admin.setApass(newpass);
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public boolean updateNewpass(int aid_aid_key, String pass, Connection conn)
			throws Exception {
		
		MyLog.log.debug("�����޸����뷽��");
		String sql = "UPDATE admin SET apass=? WHERE aid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, MyMD5.encrypt(pass));
		ps.setInt(2, aid_aid_key);
		int result = ps.executeUpdate();
		boolean flag = false;
		if (result > 0) {
			MyLog.log.debug("�޸�����ɹ�");
			flag = true;
			return flag;
		}
		return flag;
	}

}