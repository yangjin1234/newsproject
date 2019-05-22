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
     * 分页查出所有用户
     */
	public List<Userinformation> selectAllUser( Connection conn,int pageNo, int pageSize) throws Exception ;
	/**
	 * 查出最大页数
	 */
	
	
	public int getUserMaxPage(Connection conn,int pageSize) throws Exception;


	/**
	 * 查询总共有多少条用户记录
	 */
    
	 public int selectUserCount(Connection conn) throws Exception;

    

}
