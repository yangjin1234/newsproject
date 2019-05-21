package dao;

import java.sql.Connection;
import java.util.List;

import pojo.SalaryTable;
import pojo.impl.SalaryTableImpl;


public interface UserSalaryDao {
	public List<SalaryTable> selectSalaryRecorder(int sid,Connection conn) throws Exception;
    public SalaryTable selectNowSalary(int sid,Connection conn) throws Exception;
    public List<SalaryTable> selectSalarysState1(int state,Connection conn) throws Exception;
    public List<SalaryTable> selectSalarysState2(int state,Connection conn) throws Exception;
    public boolean insertSalary(SalaryTable st,Connection conn) throws Exception;
    public boolean updateSalaryState(int state,Connection conn,int sid) throws Exception;
    public boolean deleteSalaryRecorder(int sid,Connection conn) throws Exception;
    public int getMaxPage(Connection conn,int pageSize,int sid_uid_key) throws Exception;
    public List<SalaryTable>  selectAllSalary(int nid_uid_key,Connection conn,int pageNo,int pageSize) throws Exception;
    /**
     * 根据分页查询，得到数据
     * @param conn
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<SalaryTableImpl>  selectUserAllSalary(Connection conn,int pageNo,int pageSize) throws Exception;
   
    /**
     * 计算最大页数
     * @param conn
     * @param pageSize
     * @return
     * @throws Exception
     */
    public int getSalaryMaxPage(Connection conn,int pageSize) throws Exception;

    /**
     * 计算总共有多少用户数
     */
    public int selectAllUserSalaryCount(Connection conn) throws Exception;

}
