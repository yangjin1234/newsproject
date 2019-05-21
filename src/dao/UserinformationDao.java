package dao;

import java.sql.Connection;
import java.util.List;

import pojo.User;
import pojo.impl.Userinformation;
/**
 * �û���Ϣ��
 * @author Rasery
 *
 */
public interface UserinformationDao {
	/**
	 * ��ҳ��ѯ�����û���ͨ���û�״̬��ѯ�û�
	 * 1��δ��ɾ�����û�
	 * 2����ɾ�����û�
	 * @param ustate
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Userinformation> selectUserByState(int ustate, Connection conn)throws Exception;
	/**
	 * ע�᣺����һ���û���Ϣ��
	 * return true:����ɹ�
	 * return false:����ʧ��
	 * @param user
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(Userinformation user,Connection conn)throws Exception;//�д�
	/**
	 * ͨ���û������ҳ��û���ȫ����Ϣ
	 * ����һ���û�
	 * @param uname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Userinformation selectUserByName(String uname, Connection conn)throws  Exception;
	/**
	 * �����û�IDɾ���û�������ֻ���޸�״̬Ϊ0�����������ɾ���û�
	 * return 0:�޸�״̬�ɹ�
	 * return 1:�޸�״̬ʧ��
	 * @param uid
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(int uid,Connection conn)throws Exception;
	/**
	 * �޸��û���Ϣ
	 * return true:�޸ĳɹ�
	 * return false:�޸�ʧ��
	 * @param user
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(Userinformation user,Connection conn)throws Exception;

	public int selectUserId(int loginId,Connection conn)throws Exception;

	
	/**
	 * ���ݹ��ʱ���������ѯ�û���
	 */
	public String selectUserName(int sid,Connection conn)throws Exception;

	
	
}
