package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Type;

public interface TypeDao {

	/**
	 * ������еķ�������
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	List<Type> selectAllType(Connection conn)throws Exception;
}
