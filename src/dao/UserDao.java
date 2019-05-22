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
     * 查出所有用户
     */
    public List<User> selectAllUser(Connection conn)throws Exception;
    

}
