package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Type;
import pojo.impl.TypeImpl;

public interface TypeDao {

	/**
	 * ����������ͣ��Լ�ͳ������
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	List<TypeImpl> selectAllType(Connection conn)throws Exception;
}
