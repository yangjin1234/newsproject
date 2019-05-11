package dao;

import java.sql.Connection;
import java.util.List;

import pojo.SalaryTable;


public interface UserSalaryDao {
	public List<SalaryTable> selectSalaryRecorder(int sid,Connection conn) throws Exception;
    public SalaryTable selectNowSalary(int sid,Connection conn) throws Exception;
    public List<SalaryTable> selectSalarysState1(int state,Connection conn) throws Exception;
    public List<SalaryTable> selectSalarysState2(int state,Connection conn) throws Exception;
    public boolean insertSalary(SalaryTable st,Connection conn) throws Exception;
    public boolean updateSalaryState(int state,Connection conn,int sid) throws Exception;
    public boolean deleteSalaryRecorder(int sid,Connection conn) throws Exception;

}
