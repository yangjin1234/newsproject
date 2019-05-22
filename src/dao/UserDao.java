package dao;

import java.sql.Connection;
import java.util.List;

import pojo.UpdatePass;
import pojo.User;
import pojo.impl.Userinformation;
import util.MyLog;

public interface UserDao {
	public int insertRegisterMessage(User u,Connection conn) throws Exception;
    public int selectUserMessage(UpdatePass d,Connection conn) throws Exception;
    /**
     * ��ҳ��������û�
     */
	public List<Userinformation> selectAllUser( Connection conn,int pageNo, int pageSize) throws Exception ;
	/**
	 * ������ҳ��
	 */
	
	
	public int getUserMaxPage(Connection conn,int pageSize) throws Exception;


	/**
	 * ��ѯ�ܹ��ж������û���¼
	 */
    
	 public int selectUserCount(Connection conn) throws Exception;

    

}
