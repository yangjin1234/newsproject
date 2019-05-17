package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserSalaryDao;
import pojo.SalaryTable;
import pojo.impl.NewsImpl;
import util.GetDate;
import util.MyLog;

/*
 * ��ѯ��ʷ���ʱ�
 */

    
public class UserSalaryImpl implements UserSalaryDao{
	//1.��ѯĳ�û���������ʷ���ʼ�¼
	public List<SalaryTable> selectSalaryRecorder(int sid,Connection conn) throws Exception
	{
		System.out.println("conn"+conn);
		String sql="select *from salary where sid_uid_key=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, sid);
		ResultSet rs=ps.executeQuery();
		SalaryTable st=null;
		List<SalaryTable> list=new ArrayList<SalaryTable>();
		while(rs.next())
		{
			st=new SalaryTable();
			st.setSid(rs.getInt("sid"));
			st.setSdate(rs.getTimestamp("sdate"));
			st.setSalarys_state(rs.getInt("salarys_state"));
			st.setSid_uid_key(rs.getInt("sid_uid_key"));
			System.out.println("��ѯ�û����ʳɹ�");
			list.add(st);			
		}
		return list;
	}
	//2.��ѯ�û��ĵ��¹���,���Ȳ�����ݿ�����·�
    public SalaryTable selectNowSalary(int sid,Connection conn) throws Exception
    {
    	System.out.println("yuefen1===");
//    	String sql="select *from salary where sid=? and left(sdate,7) like ? ";
    	String sql="select *from salary where sid=? and MONTH(sdate)=? and YEAR(sdate)=?";
    	PreparedStatement ps=conn.prepareStatement(sql);
    	String nowdate=GetDate.getNowDate();
    	System.out.println("��ǰʱ��Ϊ��"+nowdate);
    	int a=nowdate.lastIndexOf("-");
    	int b=nowdate.indexOf("-");
    	String year=nowdate.substring(0, b);
    	System.out.println("year"+year);
    	String month=nowdate.substring(b+1, a);
    	System.out.println("month"+month);
    	ps.setInt(1, sid);
    	ps.setString(2, month);
    	ps.setString(3, year);
    	ResultSet rs=ps.executeQuery();
    	SalaryTable rt=null;
    	System.out.println("yuefen2===");
    	while(rs.next())
    	{
    		System.out.println("yuefen3===");
    		rt=new SalaryTable();
    		rt.setSid_uid_key(rs.getInt("sid_uid_key"));
    		rt.setSid(rs.getInt("sid"));
    		rt.setSdate(rs.getTimestamp("sdate"));
    		rt.setSalarys_state(rs.getInt("salarys_state"));
    		System.out.println("��ѯ�·ݳɹ�");
    	}
    	System.out.println("yuefen4==");
    	return rt;
    }
    //3.���ݲ�ѯ�����û����ʱ��¼��������й��ʵķ���״̬������ѯ���ʱ���ѷ���״̬
    public List<SalaryTable> selectSalarysState1(int state,Connection conn) throws Exception
    {
    	System.out.println("hhhhh");
    	SalaryTable st=null;
    	List<SalaryTable> list=new ArrayList<SalaryTable>();
    	if(state==1)
    	{
    	System.out.println("=====");
    	String sql="select *from salary where salarys_state=?";
    	PreparedStatement ps=conn.prepareStatement(sql);
    	ps.setInt(1, state);
    	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		st=new SalaryTable();
    		st.setSid_uid_key(rs.getInt("sid_uid_key"));
    		st.setSid(rs.getInt("sid"));
    		st.setSdate(rs.getTimestamp("sdate"));
    		st.setSalarys_state(rs.getInt("salarys_state"));
    		st.setSalarys(rs.getDouble("salarys"));
    		System.out.println("�����ѷ���");
    		list.add(st);
    	}
    	return list;
    	}
    	else
    	{
    		System.out.println("����δ����");
    	}
    	return list;
 
    }
    //4.��ѯδ���ŵĹ���
    public List<SalaryTable> selectSalarysState2(int state,Connection conn) throws Exception
    {
    	System.out.println("����δ�������=====");
    	SalaryTable st=null;
    	List<SalaryTable> list=new ArrayList<SalaryTable>();
    	if(state==0)
    	{
    	String sql="select *from salary where salarys_state=?";
    	PreparedStatement ps=conn.prepareStatement(sql);
    	ps.setInt(1, state);
    	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		st=new SalaryTable();
    		st.setSid_uid_key(rs.getInt("sid_uid_key"));
    		st.setSid(rs.getInt("sid"));
    		st.setSdate(rs.getTimestamp("sdate"));
    		st.setSalarys_state(rs.getInt("salarys_state"));
    		System.out.println("����δ����");
    		list.add(st);
    	}
    	return list;
    	}
    	else
    	{
    		System.out.println("�����ѷ���");
    		return list;
    	}
    }

    //5.���빤�ʼ�¼
    public boolean insertSalary(SalaryTable st,Connection conn) throws Exception
    {
    	int sid=st.getSid();
    	int sid_uid_key=st.getSid_uid_key();
    	double salarys=st.getSalarys();
    	//�õ���ǰ���·ݼ�ʱ��
    	String nowdate=GetDate.getNowDate();
    	System.out.println("��ǰʱ��Ϊ��"+nowdate);
    	String sql="insert into salary(sdate,sid,sid_uid_key,salarys) value(?,?,?,?)";
    	PreparedStatement ps=conn.prepareStatement(sql);
    	ps.setTimestamp(1, GetDate.getNowDate2(nowdate));
    	ps.setInt(2,sid);
    	ps.setInt(3,sid_uid_key );
    	ps.setDouble(4, salarys);
    	int result=ps.executeUpdate();
    	boolean flag=false;
    	if(result>0)
    	{
    		System.out.println("���빤�ʼ�¼�ɹ�");
    		flag=true;
    		return flag;
    	}
    	return flag;	
    }
    //6.�޸Ĺ��ʵķ���״̬
    public boolean updateSalaryState(int state,Connection conn,int sid) throws Exception
    {
    	System.out.println("xiugai------");
    	String sql="update  salary set salarys_state=? where sid=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, state);
		ps.setInt(2, sid);
		int result=ps.executeUpdate();
		boolean flag=false;
		if(result>0)
		{
			System.out.println("�޸ķ���״̬�ɹ�");
			flag=true;
		    return flag;
		}
		return flag;
    }
    //7.ɾ�����ʼ�¼���ݹ��ʱ�����
    public boolean deleteSalaryRecorder(int sid,Connection conn) throws Exception
	{
		String sql="delete from salary where sid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, sid);
		int count=ps.executeUpdate();
		boolean flag=false;
		if(count>0)
		{
			flag=true;
			System.out.println("ɾ���ɹ�==");
			return flag;
		}
		return flag;
	}
    
    /*
     * ��ѯ�û������й��ʼ�¼���÷�ҳ����
     */
    public List<SalaryTable>  selectAllSalary(int nid_uid_key,Connection conn,int pageNo,int pageSize) throws Exception
	  {
		  List<SalaryTable> list=new ArrayList<SalaryTable>();
		  String sql="select *from Salary where sid_uid_key=?  limit ?,?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ResultSet rs=null;
		  ps.setInt(1, nid_uid_key);
		  ps.setInt(2, (pageNo-1)*pageSize);
		  ps.setInt(3, pageSize);
		  rs=ps.executeQuery();
		  while(rs.next())
		  {
			  
			  SalaryTable s=new SalaryTable();
			  s.setSalarys(rs.getDouble("salarys"));
			  s.setSalarys_state(rs.getInt("salarys_state"));
			  s.setSdate(rs.getTimestamp("sdate"));
			  s.setSid(rs.getInt("sid"));
			  s.setSid_uid_key(rs.getInt("sid_uid_key"));
			  MyLog.log.debug("��ѯ��ҳ�����ݳɹ�");
			  list.add(s);
		  }
		  return list;
	  }
    //�������ҳ��
    public int getMaxPage(Connection conn,int pageSize,int sid_uid_key) throws Exception
	  {
		  String sql="select count(*) as max from salary where sid_uid_key=?";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1, sid_uid_key);
		  ResultSet rs=null;
		  int count=0;
		  try {
			  rs=ps.executeQuery();
			  while(rs.next())
			  {
				  count=rs.getInt("max");
				  System.out.println("count===="+count);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return count%pageSize==0?count/pageSize:count/pageSize+1;
	  }
}
