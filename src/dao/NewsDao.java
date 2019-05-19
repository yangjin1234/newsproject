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
	public boolean updateNews(News n,Connection conn) throws Exception;
	public boolean updateSalaryState(int nid,int nsalary_state,Connection conn) throws Exception;
	public boolean updateNewsState(int nid,int news_state,Connection conn) throws Exception;
	public List<NewsImpl> selectAllNews(int nid_uid_key,Connection conn,int pageNo,int pageSize) throws Exception;
	public List<News>  selectNewsByTitle(int nid_uid_key,Connection conn,int pageNo,int pageSize,String title) throws Exception;
	public int getMaxPage(Connection conn,int pageSize) throws Exception;
	public int getMaxPageByUid(Connection conn,int pageSize,int uid) throws Exception;
	public int getAllNewsSum(Connection conn,int uid)throws Exception;
	/**
	 * 各种状态下的文章
	 * @param nid_uid_key
	 * @param conn
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<NewsImpl> selectAllNewsByState(int nid_uid_key,Connection conn,int pageNo,int pageSize,int state) throws Exception;
	int selectAllNewsByStateFormaxPage(int nid_uid_key,Connection conn,int pageSize,int state) throws Exception;
	int selectAllNewsByStateForSum(int nid_uid_key,Connection conn,int state) throws Exception;
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
	int selectNewsByTypeNameForMaxSize(int nid_uid_key,Connection conn,String typeName,int pageSize)throws Exception;

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
	int selectNewsByTimeForMaxSize(int nid_uid_key,Connection conn,String timeName,int pageSize)throws Exception;
	
	/**
	 * 找出各种状态的的工资总和
	 */
	double selectSumSalaryNo(int nid_uid_key,Connection conn,int state)throws Exception;
	/**
	 * 根据用户主键及文章已通过审核，查询本用户的所有文章
	 */
		public List<News>  selectAllNews(int nid_uid_key,int news_state,Connection conn,int pageNo,int pageSize) throws Exception;
	/**
	 * 根据用户主键及文章已通过审核，查询本用户的文章数
	 */
		public int selectAllNews(int nid_uid_key,int news_state,Connection conn) throws Exception;

	/**
	 * 根据用户主键及文章已通过审核，计算出最大页数
	 */
		 public int getMaxPage(Connection conn,int pageSize,int nid_uid_key,int news_state) throws Exception;
		 
		 
		 /**
		  * 根据用户名主键及文章已通过审核，分页今日查询出每页数据
		  */
		 		 public List<News> selectNewsDay(Connection conn,int nid_uid_key,int news_state,int pageNo,int pageSize) throws Exception;
		 /**
		  *  根据用户名主键及文章已通过审核，每页显示几条数据，计算出今日总共有多少页
		  */
		 		 public int getMaxPageDay(Connection conn,int pageSize,int nid_uid_key,int news_state) throws Exception;
		 /**
		  * 根据用户名主键及文章已通过审核，计算出今日的文章数
		  */
		 		 public int selectNewsLastDayCount(int nid_uid_key,int news_state,Connection conn) throws Exception;
		 		
		 		 
		 		 /**
		 		  * 根据用户名主键及文章已通过审核，分页昨日查询出每页数据
		 		  */
		 		 public List<News> selectNewsLastDay(Connection conn,int nid_uid_key,int news_state,int pageNo,int pageSize) throws Exception;
		 		 /**
		 		  *  根据用户名主键及文章已通过审核，每页显示几条数据，计算出昨日总共有多少页
		 		  */
		 		 public int getMaxPageLastDay(Connection conn,int pageSize,int nid_uid_key,int news_state) throws Exception;
		 		 /**
		 		  * 根据用户名主键及文章已通过审核，计算出昨日的文章数
		 		  */
		 		 public int selectNewsDayCount(int nid_uid_key,int news_state,Connection conn) throws Exception;
		 		 
		 		 
		 		 /**
		 		  * 根据用户名主键及文章已通过审核，分页出本月查询出每页数据
		 		  */
		 		 public List<News> selectNewsMonth(Connection conn,int nid_uid_key,int news_state,int pageNo,int pageSize) throws Exception;
		 		 /**
		 		  *  根据用户名主键及文章已通过审核，每页显示几条数据，计算出本月总共有多少页
		 		  */
		 		 public int getMaxPageMonth(Connection conn,int pageSize,int nid_uid_key,int news_state) throws Exception;
		 		 /**
		 		  * 根据用户名主键及文章已通过审核，计算出本月的文章数
		 		  */
		 		 public int selectNewsMonthCount(int nid_uid_key,int news_state,Connection conn) throws Exception;


}
