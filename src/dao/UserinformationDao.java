package dao;

import java.sql.Connection;
import java.util.List;

import pojo.User;
import pojo.impl.Userinformation;
/**
 * 用户信息表
 * @author Rasery
 *
 */
public interface UserinformationDao {
	/**
	 * 分页查询所有用户：通过用户状态查询用户
	 * 1：未被删除的用户
	 * 2：已删除的用户
	 * @param ustate
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Userinformation> selectUserByState(int ustate, Connection conn)throws Exception;
	/**
	 * 注册：插入一条用户信息表
	 * return true:插入成功
	 * return false:插入失败
	 * @param user
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean saveUser(Userinformation user,Connection conn)throws Exception;//有错
	/**
	 * 通过用户名查找出用户的全部信息
	 * 返回一个用户
	 * @param uname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Userinformation selectUserByName(String uname, Connection conn)throws  Exception;
	/**
	 * 根据用户ID删除用户，但是只是修改状态为0，并不是真的删除用户
	 * return 0:修改状态成功
	 * return 1:修改状态失败
	 * @param uid
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(int uid,Connection conn)throws Exception;
	/**
	 * 修改用户信息
	 * return true:修改成功
	 * return false:修改失败
	 * @param user
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(Userinformation user,Connection conn)throws Exception;

	public int selectUserId(int loginId,Connection conn)throws Exception;

	
	/**
	 * 根据工资表主键，查询用户名
	 */
	public String selectUserName(int sid,Connection conn)throws Exception;

	
	
}
