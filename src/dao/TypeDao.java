package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Type;

public interface TypeDao {

	/**
	 * 查出所有的分类类型
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	List<Type> selectAllType(Connection conn)throws Exception;
}
