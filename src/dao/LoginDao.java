package dao;

import java.sql.Connection;


import pojo.Login;
import pojo.User;
/**
 * ��½��
 */
public interface LoginDao {
	/**
	 * ��½ʱͨ���ж��û������������Ƿ�ƥ����ȷ���Ƿ��ܵ�¼
	 * return 1:���Ե�¼
	 * return 0:�޸��û�
	 * return 2:�������
	 * @param lname
	 * @param lpass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int Login(String lname,String lpass,Connection conn) throws Exception;
	/**
	 * ע�᣺����һ����¼����Ϣ
	 * return true:����ɹ�
	 * return false: ����ʧ��
	 * @param login
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean saveLogin(Login login,Connection conn) throws Exception;
	/**
	 * ͨ�����û������ֲ�ѯ���û��Ƿ����
	 * return true:����
	 * return false:������
	 * @param lname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean selectUserByName(String lname,Connection conn)throws Exception;
	/**
	 * ͨ�����û������ֲ�ѯ���û�
	 * return true:����
	 * return false:������
	 * @param lname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Login selectUserPassByName(String lname,Connection conn)throws Exception;
	/**
	 * �޸����룺ͨ���û��������������������������
	 * return true:�޸ĳɹ�
	 * return false:�޸�ʧ��
	 * @param lname
	 * @param oldpass
	 * @param newpass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean updatePass(String lname, String newpass, Connection conn)throws Exception;
}
