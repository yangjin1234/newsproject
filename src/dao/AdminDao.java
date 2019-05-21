package dao;

import java.sql.Connection;

import pojo.Admin;
import pojo.Login;

public interface AdminDao {

	/**
	 * ��½ʱͨ���жϹ���T�����������Ƿ�ƥ����ȷ���Ƿ��ܵ�¼
	 * return 1:���Ե�¼
	 * return 0:�޸��û�
	 * return 2:�������
	 * @param aname
	 * @param apass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int Login(String aname,String apass,Connection conn) throws Exception;
	/**
	 * ע�᣺����һ����¼����Ϣ
	 * return true:����ɹ�
	 * return false: ����ʧ��
	 * @param login
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean saveLogin(Admin admin,Connection conn) throws Exception;
	/**
	 * ͨ���ù���T�����ֲ�ѯ���û��Ƿ����
	 * return true:����
	 * return false:������
	 * @param aname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean selectUserByName(String aname,Connection conn)throws Exception;
	/**
	 * ͨ���ù���T�����ֲ�ѯ���û�
	 * return true:����
	 * return false:������
	 * @param aname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Admin selectUserPassByName(String aname,Connection conn)throws Exception;
	/**
	 * �޸����룺ͨ������T�������������������������
	 * return true:�޸ĳɹ�
	 * return false:�޸�ʧ��
	 * @param aname
	 * @param oldpass
	 * @param newpass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean updatePass(String aname, String newpass, Connection conn)throws Exception;
	 public boolean updateNewpass(int aid_aid_key,String pass,Connection conn) throws Exception;
	
	
}
