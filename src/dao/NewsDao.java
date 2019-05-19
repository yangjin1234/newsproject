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
	 * ����״̬�µ�����
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
	 * ��ʱ���ѯ���ಢͳ������
	 */
	List<TimeTypec> selectAllByTime(Connection conn, int nid_uid_key)throws Exception;

	/**
	 * �������ѯ
	 * @param nid_uid_key
	 * @param conn
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	List<NewsImpl> selectNewsByTypeName(int nid_uid_key,Connection conn,String typeName,int pageNo,int pageSize)throws Exception;
	int selectNewsByTypeNameForMaxSize(int nid_uid_key,Connection conn,String typeName,int pageSize)throws Exception;

	/**
	 * ��ʱ������ѯ
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
	 * �ҳ�����״̬�ĵĹ����ܺ�
	 */
	double selectSumSalaryNo(int nid_uid_key,Connection conn,int state)throws Exception;
	/**
	 * �����û�������������ͨ����ˣ���ѯ���û�����������
	 */
		public List<News>  selectAllNews(int nid_uid_key,int news_state,Connection conn,int pageNo,int pageSize) throws Exception;
	/**
	 * �����û�������������ͨ����ˣ���ѯ���û���������
	 */
		public int selectAllNews(int nid_uid_key,int news_state,Connection conn) throws Exception;

	/**
	 * �����û�������������ͨ����ˣ���������ҳ��
	 */
		 public int getMaxPage(Connection conn,int pageSize,int nid_uid_key,int news_state) throws Exception;



}
