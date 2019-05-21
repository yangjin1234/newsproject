package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Type;
import pojo.impl.TypeImpl;

public interface TypeDao {

	/**
	 * 查出所有类型，以及统计数量
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	List<TypeImpl> selectAllType(Connection conn)throws Exception;
	/**
	 * 查出數據庫中的所有類型
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	List<TypeImpl> selectAllTypeInDB(Connection conn)throws Exception;
	
	/**
	 * 按分类名查找分类
	 */
	Type selectTypeByTname(Connection conn,String typename)throws Exception;
}
