package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Inform;

public interface InformDao {
	/**
	 * ��ҳ��ѯ�����й���
	 * @param conn
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
		public List<Inform> selectInform(Connection conn,int pageNo,int pageSize)throws Exception;
		/**
		 * ���ҳ��
		 * @param conn
		 * @param pageSize
		 * @return
		 * @throws Exception
		 */
		public int selectInformMaxPage(Connection conn,int pageSize)throws Exception;
		/**
		 * ����һ������
		 * @param conn
		 * @param inform
		 * @return
		 * @throws Exception
		 */
		public boolean insertOneInform(Connection conn,Inform inform)throws Exception;
}
