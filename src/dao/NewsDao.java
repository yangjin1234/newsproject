package dao;

import java.sql.Connection;
import java.util.List;

import pojo.News;
import pojo.impl.NewsImpl;
import pojo.impl.TimeTypec;
public interface NewsDao {
	public boolean insertNews(News n,Connection conn) throws Exception;
	public boolean deleteNews(int nid,Connection conn) throws Exception;
	public boolean updateNewsSalary(double nsalary,Connection conn,int nid) throws Exception;
	public boolean updateState(int state,Connection conn,int nid) throws Exception;
	public boolean updateSalaryState(int nid,int nsalary_state,Connection conn) throws Exception;
	public boolean updateNewsState(int nid,int news_state,Connection conn) throws Exception;
	public List<NewsImpl> selectAllNews(int nid_uid_key,Connection conn,int pageNo,int pageSize) throws Exception;
	public List<News>  selectNewsByTitle(int nid_uid_key,Connection conn,int pageNo,int pageSize,String title) throws Exception;
	public int getMaxPage(Connection conn,int pageSize) throws Exception;
	/**
	 * 按时间查询分类并统计数量
	 */
	List<TimeTypec> selectAllByTime(Connection conn, int nid_uid_key)throws Exception;

	/**
	 * 按分类查询
	 * @param nid_uid_key
	 * @param conn
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	List<NewsImpl> selectNewsByTypeName(int nid_uid_key,Connection conn,String typeName,int pageNo,int pageSize)throws Exception;

	/**
	 * 按时间分类查询
	 * @param nid_uid_key
	 * @param conn
	 * @param timeName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<NewsImpl> selectNewsByTime(int nid_uid_key,Connection conn,String timeName,int pageNo,int pageSize)throws Exception;
}
