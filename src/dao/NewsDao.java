package dao;

import java.sql.Connection;
import java.util.List;

import pojo.News;
import pojo.impl.TimeType;
public interface NewsDao {
	public boolean insertNews(News n,Connection conn) throws Exception;
	public boolean deleteNews(int nid,Connection conn) throws Exception;
	public boolean updateNewsSalary(double nsalary,Connection conn,int nid) throws Exception;
	public boolean updateState(int state,Connection conn,int nid) throws Exception;
	public boolean updateSalaryState(int nid,int nsalary_state,Connection conn) throws Exception;
	public boolean updateNewsState(int nid,int news_state,Connection conn) throws Exception;
	public List<News> selectAllNews(int nid_uid_key,Connection conn,int pageNo,int pageSize) throws Exception;
	public List<News>  selectNewsByTitle(int nid_uid_key,Connection conn,int pageNo,int pageSize,String title) throws Exception;
	public int getMaxPage(Connection conn,int pageSize) throws Exception;
	/**
	 * 按时间查询分类并统计数量
	 */
	List<TimeType> selectAllByTime(Connection conn, int nid_uid_key)throws Exception;



}
