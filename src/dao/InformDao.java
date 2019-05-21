package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Inform;

public interface InformDao {
	/**
	 * 分页查询出所有公告
	 * @param conn
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
		public List<Inform> selectInform(Connection conn,int pageNo,int pageSize)throws Exception;
		/**
		 * 最大页数
		 * @param conn
		 * @param pageSize
		 * @return
		 * @throws Exception
		 */
		public int selectInformMaxPage(Connection conn,int pageSize)throws Exception;
		/**
		 * 插入一条公告
		 * @param conn
		 * @param inform
		 * @return
		 * @throws Exception
		 */
		public boolean insertOneInform(Connection conn,Inform inform)throws Exception;
}
