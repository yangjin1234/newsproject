package dao;

import java.sql.Connection;
import java.util.List;

import pojo.UpdatePass;
import pojo.User;
import util.MyLog;

public interface UserDao {
	public int insertRegisterMessage(User u,Connection conn) throws Exception;
    public int selectUserMessage(UpdatePass d,Connection conn) throws Exception;
    /**
     * ��������û�
     */
    public List<User> selectAllUser(Connection conn)throws Exception;
    

}
