package dao;

import java.sql.Connection;


import pojo.Login;
import pojo.User;
/**
 * 登陆表
 */
public interface LoginDao {
	/**
	 * 登陆时通过判断用户姓名与密码是否匹配来确认是否能登录
	 * return 1:可以登录
	 * return 0:无该用户
	 * return 2:密码错误
	 * @param lname
	 * @param lpass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int Login(String lname,String lpass,Connection conn) throws Exception;
	/**
	 * 注册：插入一条登录表信息
	 * return true:插入成功
	 * return false: 插入失败
	 * @param login
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean saveLogin(Login login,Connection conn) throws Exception;
	/**
	 * 通过该用户的名字查询该用户是否存在
	 * return true:存在
	 * return false:不存在
	 * @param lname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean selectUserByName(String lname,Connection conn)throws Exception;
	/**
	 * 通过该用户的名字查询该用户
	 * return true:存在
	 * return false:不存在
	 * @param lname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Login selectUserPassByName(String lname,Connection conn)throws Exception;
	/**
	 * 修改密码：通过用户输入的姓名新密码来更改密码
	 * return true:修改成功
	 * return false:修改失败
	 * @param lname
	 * @param oldpass
	 * @param newpass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean updatePass(String lname, String newpass, Connection conn)throws Exception;
}
