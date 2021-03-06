package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Admin;
import pojo.Login;
import pojo.UpdatePass;
import pojo.impl.AdminImpl;

public interface AdminDao {

	/**
	 * 登陆时通过判断管理員姓名与密码是否匹配来确认是否能登录
	 * return 1:可以登录
	 * return 0:无该用户
	 * return 2:密码错误
	 * @param aname
	 * @param apass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int Login(String aname,String apass,Connection conn) throws Exception;
	/**
	 * 注册：插入一条登录表信息
	 * return true:插入成功
	 * return false: 插入失败
	 * @param login
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean saveLogin(Admin admin,Connection conn) throws Exception;
	/**
	 * 通过该管理員的名字查询该用户是否存在
	 * return true:存在
	 * return false:不存在
	 * @param aname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean selectUserByName(String aname,Connection conn)throws Exception;
	/**
	 * 通过该管理員的名字查询该用户
	 * return true:存在
	 * return false:不存在
	 * @param aname
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public Admin selectUserPassByName(String aname,Connection conn)throws Exception;
	/**
	 * 修改密码：通过管理員输入的姓名新密码来更改密码
	 * return true:修改成功
	 * return false:修改失败
	 * @param aname
	 * @param oldpass
	 * @param newpass
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public boolean updatePass(String aname, String newpass, Connection conn)throws Exception;
	 public boolean updateNewpass(int aid_aid_key,String pass,Connection conn) throws Exception;
	 /**
	  * 分页查询出所有待审核的管理员
	  * @param conn
	  * @param pageNo
	  * @param pageSize
	  * @return
	  * @throws Exception
	  */
	public List<Admin> selectAllNotPathAdmin(Connection conn,int pageNo,int pageSize)throws Exception;
	public int selectAllNotPathAdminForMaxPage(Connection conn,int pageSize)throws Exception;
	public int selectAllNotPathAdminSum(Connection conn)throws Exception;
	/**
	 * 分页查询出其他状态的管理员
	 * @param conn
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Admin> selectAllAdminByAcheck(Connection conn,int pageNo,int pageSize,int acheck)throws Exception;
	public int selectAllAdminByAcheckForMaxPage(Connection conn,int pageSize,int acheck)throws Exception;
	public int selectAllAdminByAcheckSum(Connection conn,int acheck)throws Exception;
	
	/**
	 * 修改状态
	 * @param aid
	 * @param conn
	 * @param acheck
	 * @return
	 * @throws Exception
	 */
	boolean updateAdminCheckState(int aid,Connection conn,int acheck)throws Exception;
	/**
	 * 将注册信息存入admin表中
	 * @param u
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	
	public boolean insertRegisterMessage(AdminImpl u,Connection conn) throws Exception;

	
	/**
	 * 修改密码操作
	 * @param d
	 * @param conn
	 * @return
	 * @throws Exception
	 */
		
		public boolean selectAdminMessage(UpdatePass d,Connection conn) throws Exception;

}
