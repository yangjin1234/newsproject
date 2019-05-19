package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NewsDao;
import pojo.News;
import pojo.impl.NewsImpl;
import pojo.impl.TimeTypec;
import util.GetDate;
import util.MyLog;

/*
 * 1.表示工资为发放
 * 2.表示工资已发放
 * 0.表示新闻稿为发布
 * 1.表示为发布
 * 2.表示正在审核
 */

public class NewsDaoImpl implements NewsDao{

	//1.插入一条新闻
	public boolean insertNews(News n,Connection conn) throws Exception
	{
		String sql="insert into news(nid,nid_uid_key,ntitle,ncontent,nsalary,nupload_time,namend_time,nid_tid_key) value(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		String nowdate=GetDate.getNowDate();
    	System.out.println("当前时间为："+nowdate);
		ps.setInt(1, n.getNid());
		ps.setDouble(2, n.getNid_uid_key());
		ps.setString(3, n.getTitle());
		ps.setString(4, n.getNcontent());
		ps.setDouble(5, n.getNsalary());
		ps.setTimestamp(6, GetDate.getNowDate2(nowdate));
		ps.setTimestamp(7, GetDate.getNowDate2(nowdate));
		ps.setInt(8, n.getNid_tid_key());
		int result=ps.executeUpdate();
		boolean flag=false;
		if(result>0)
		{
			System.out.println("执行成功");
			System.out.println("==================================");
			flag=true;
			return flag;
		}
		    return flag;
	}
	//2.修改新闻状态为已发布
	public boolean updateState(int state,Connection conn,int nid) throws Exception
	{
		String sql="update  news set news_state=? ,namend_time=? where nid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		String nowdate=GetDate.getNowDate();
    	System.out.println("当前时间为："+nowdate);
		ps.setInt(1, state);
		ps.setTimestamp(2, GetDate.getNowDate2(nowdate));
		ps.setInt(3, nid);
		int result=ps.executeUpdate();
		boolean flag=false;
		if(result>0)
		{
			System.out.println("修改状态成功");
			flag=true;
		    return flag;
		}
		return flag;
	}
	//3.根据新闻的id，删除一条新闻
	  public boolean deleteNews(int nid,Connection conn) throws Exception
		{
			String sql="delete from news where nid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, nid);
			int count=ps.executeUpdate();
			boolean flag=false;
			if(count>0)
			{
				flag=true;
				System.out.println("删除一条新闻成功");
				return flag;
			}
			return flag;
		}
	//4.根据新闻id，修改稿费
	  
	  public boolean updateNewsSalary(double nsalary,Connection conn,int nid) throws Exception
		{
			String sql="update  news set nsalary=?  where nid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, nsalary);
			ps.setInt(2, nid);
			int result=ps.executeUpdate();
			boolean flag=false;
			if(result>0)
			{
				System.out.println("修改状态成功");
				flag=true;
			    return flag;
			}
			return flag;
		}
	  //5.根据id，修改工资状态为已发放状态(2为已发放)
	  public boolean updateSalaryState(int nid,int nsalary_state,Connection conn) throws Exception
			{
				String sql="update  news set nsalary_state=?  where nid=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setDouble(1, nsalary_state);
				ps.setInt(2, nid);
				int result=ps.executeUpdate();
				boolean flag=false;
				if(result>0)
				{
					System.out.println("修改状态成功");
					flag=true;
				    return flag;
				}
				return flag;
			}
	  //6.根据用户主键，分页查询出该用户的所有新闻
	  public List<NewsImpl> selectAllNews(int nid_uid_key,Connection conn,int pageNo,int pageSize) throws Exception
	  {
		  List<NewsImpl> list=new ArrayList<NewsImpl>();
		  String sql="select *from news,type where nid_uid_key=? and nid_tid_key=tid  limit ?,?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, (pageNo-1)*pageSize);
		  ps.setInt(3, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  NewsImpl n=new NewsImpl();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_tid_key(rs.getInt("nid_tid_key"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  n.setTypename(rs.getString("tname"));
			  list.add(n);
		  }
		  return list;
	  }
	  //7.按新闻标题模糊查询并进行分页
	  public List<News> selectNewsByTitle(int nid_uid_key,Connection conn,int pageNo,int pageSize,String title) throws Exception
	  {
		  List<News> list=new ArrayList<News>();
		  String sql="select *from news where nid_uid_key=? and ntitle like ? limit ?,?";
		  PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setString(2, "%"+title+"%");
		  ps.setInt(3, (pageNo-1)*pageSize);
		  ps.setInt(4, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  News n=new News();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_tid_key(rs.getInt("nid_tid_key"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  System.out.println("查询成功");
			  list.add(n);
		  }
		  return list;
	  }
	  //计算新闻的最大页数,用于分页技术
	  public int getMaxPage(Connection conn,int pageSize) throws Exception
	  {
		  String sql="select count(*) as max from news";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  if(rs.next())
			  {
				  count=rs.getInt("max");
				  System.out.println("count===="+count);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count%pageSize==0?count/pageSize:count/pageSize+1;
	  }
	  //8.修改新闻状态为已审核
	  public boolean updateNewsState(int nid,int news_state,Connection conn) throws Exception
		{
			String sql="update  news set news_state=?  where nid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, news_state);
			ps.setInt(2, nid);
			int result=ps.executeUpdate();
			boolean flag=false;
			if(result>0)
			{
				System.out.println("修改状态成功");
				flag=true;
			    return flag;
			}
			return flag;
		}
	public List<TimeTypec> selectAllByTime(Connection conn, int nid_uid_key)throws Exception {
		String sql="select YEAR(nupload_time) as tyear,MONTH(nupload_time) as tmonth,count(*) as number from news where nid_uid_key  group by YEAR(nupload_time) , MONTH(nupload_time) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<TimeTypec> list=new ArrayList<TimeTypec>();
		while(rs.next()){
			TimeTypec tt=new TimeTypec();
			tt.setTimec(rs.getInt("tyear")+"年"+rs.getInt("tmonth")+"月");
			tt.setNumber(rs.getInt("number"));
			list.add(tt);
		}
		return list;
	}
	public List<NewsImpl> selectNewsByTypeName(int nid_uid_key,
			Connection conn, String typeName,int pageNo,int pageSize) throws Exception {
		 List<NewsImpl> list=new ArrayList<NewsImpl>();
		  String sql="select * from news,type where nid_uid_key=? and news.nid_tid_key=type.tid and tname=? limit ?,?";
		  PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setString(2, typeName);
		  ps.setInt(3, (pageNo-1)*pageSize);
		  ps.setInt(4, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  NewsImpl n=new NewsImpl();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_tid_key(rs.getInt("nid_tid_key"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  System.out.println("查询成功");
			  list.add(n);
		  }
		  return list;
	}
	public List<NewsImpl> selectNewsByTime(int nid_uid_key, Connection conn,
			String timeName, int pageNo, int pageSize) throws Exception {
		List<NewsImpl> list=new ArrayList<NewsImpl>();
		  String sql="select * from news WHERE nid_uid_key=? and year(news.nupload_time)=? and month(news.nupload_time)=? limit ?,?;";
		  PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  
		  //转换时间
			int  one=timeName.indexOf("年");
			int  two=timeName.indexOf("月");
			String years=timeName.substring(0, one);
			String months=timeName.substring(one+1,two);
			int year=Integer.parseInt(years);
			int month=Integer.parseInt(months);
		  
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, year);
		  ps.setInt(3, month);
		  ps.setInt(4, (pageNo-1)*pageSize);
		  ps.setInt(5, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  NewsImpl n=new NewsImpl();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_tid_key(rs.getInt("nid_tid_key"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  System.out.println("查询成功");
			  list.add(n);
		  }
		  return list;
	}
	public int selectNewsByTypeNameForMaxSize(int nid_uid_key, Connection conn,
			String typeName,int pageSize) throws Exception {
		String sql="select count(*) as number from news,type where nid_uid_key=? and news.nid_tid_key=type.tid and tname=?";
		 PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setString(2, typeName);
		   rs=ps.executeQuery();
		   int count=0;
			  if(rs.next()){
				  count=rs.getInt("number");
			  }
			return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
	public int selectNewsByTimeForMaxSize(int nid_uid_key, Connection conn,
			String timeName,int pageSize) throws Exception {
		String sql="select count(*) as number from news WHERE nid_uid_key=? and year(news.nupload_time)=? and month(news.nupload_time)=?";
		//转换时间
		int  one=timeName.indexOf("年");
		int  two=timeName.indexOf("月");
		String years=timeName.substring(0, one);
		String months=timeName.substring(one+1,two);
		int year=Integer.parseInt(years);
		int month=Integer.parseInt(months);
		 PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
	  ps.setInt(1, nid_uid_key);
	  ps.setInt(2, year);
	  ps.setInt(3, month);
		   rs=ps.executeQuery();
		   int count=0;
		  if(rs.next()){
			  count=rs.getInt("number");
		  }
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
	public double selectSumSalaryNo(int nid_uid_key, Connection conn,int state)
			throws Exception {
		String sql="SELECT sum(nsalary) as nofa FROM news WHERE nsalary_state=? and nid_uid_key=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, state);
		ps.setInt(2, nid_uid_key);
		ResultSet rs=ps.executeQuery();
		double num=0;
		if(rs.next()){
			num=rs.getDouble("nofa");
		}
		return num;
	}
	  
	/*
	 * 根据用户主键及工资表主键，查询该用户的新闻编号
	 * 
	 */
	
	public boolean selectNewsKey(int nid_uid_key,int sid,Connection conn) throws Exception
	  {
		  List<NewsImpl> list=new ArrayList<NewsImpl>();
		  String sql="select *from news where nid_uid_key=? and sid=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, sid);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  NewsImpl n=new NewsImpl();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  n.setTypename(rs.getString("tname"));
			  return true;
		  }
		  return false;
	  }
	public int getMaxPageByUid(Connection conn, int pageSize, int uid)
			throws Exception {
		  String sql="select count(*) as max from news where nid_uid_key=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, uid);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  if(rs.next())
			  {
				  count=rs.getInt("max");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count%pageSize==0?count/pageSize:count/pageSize+1;
	  }
	public int getAllNewsSum(Connection conn, int uid)throws Exception {
		 String sql="select count(*) as max from news where nid_uid_key=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, uid);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  if(rs.next())
			  {
				  count=rs.getInt("max");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public List<NewsImpl> selectAllNewsByState(int nid_uid_key,
			Connection conn, int pageNo, int pageSize, int state)
			throws Exception {
		List<NewsImpl> list=new ArrayList<NewsImpl>();
		  String sql="select *from news,type where nid_uid_key=? and nid_tid_key=tid and news_state=? limit ?,?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, state);
		  ps.setInt(3, (pageNo-1)*pageSize);
		  ps.setInt(4, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  NewsImpl n=new NewsImpl();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_tid_key(rs.getInt("nid_tid_key"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  n.setTypename(rs.getString("tname"));
			  list.add(n);
		  }
		  return list;
	}
	public int selectAllNewsByStateFormaxPage(int nid_uid_key, Connection conn,
			int pageSize, int state) throws Exception {
		String sql="select count(*) as max from news where nid_uid_key=? and news_state=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, state);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  if(rs.next())
			  {
				  count=rs.getInt("max");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
	public int selectAllNewsByStateForSum(int nid_uid_key, Connection conn,
			int state) throws Exception {
		String sql="select count(*) as max from news where nid_uid_key=? and news_state=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, state);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  if(rs.next())
			  {
				  count=rs.getInt("max");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count;
	}
	
	public int selectAllNews(int nid_uid_key,int news_state,Connection conn) throws Exception
	{
		
		String sql="select count(*) as number from news where nid_uid_key=? and news_state=?";
		 PreparedStatement ps=null;
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, news_state);
		   rs=ps.executeQuery();
		   int count=0;
			  if(rs.next()){
				  count=rs.getInt("number");
				  MyLog.log.debug("该用户已通过审核的新闻数为"+count);
			  }
			return count;
		
		
	}	
	 public List<News>  selectAllNews(int nid_uid_key,int news_state,Connection conn,int pageNo,int pageSize) throws Exception
	  {
		  List<News> list=new ArrayList<News>();		
		  String sql="select *from news where nid_uid_key=? and news_state=? limit ?,?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2,news_state );
		  ps.setInt(3, (pageNo-1)*pageSize);
		  ps.setInt(4, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  News n=new News();
			  n.setNamend_time(rs.getTimestamp("namend_time"));
			  n.setNcontent(rs.getString("ncontent"));
			  n.setNews_state(rs.getInt("news_state"));
			  n.setNid(rs.getInt("nid"));
			  n.setNid_uid_key(rs.getInt("nid_uid_key"));
			  n.setNsalary(rs.getDouble("nsalary"));
			  n.setNsalary_state(rs.getInt("nsalary_state"));
			  n.setNupload_time(rs.getTimestamp("nupload_time"));
			  n.setTitle(rs.getString("ntitle"));
			  n.setNid_tid_key(rs.getInt("nid_tid_key"));
			  n.setNid_sid_key(rs.getInt("nid_sid_key"));
			  MyLog.log.debug("查询出了数据===");
			  list.add(n);
		  }
		  return list;
	  }
	/**
	 *计算最大页数
	 */

	 public int getMaxPage(Connection conn,int pageSize,int nid_uid_key,int news_state) throws Exception
	  {
		  String sql="select count(*) as max from news where nid_uid_key=? and news_state=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, news_state);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  while(rs.next())
			  {
				  count=rs.getInt("max");
				  MyLog.log.debug("count=="+count);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count%pageSize==0?count/pageSize:count/pageSize+1;
	  }
	public boolean updateNews(News n, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
	


	

