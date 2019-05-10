package dao;

import java.sql.Connection;
import java.util.ArrayList;

import pojo.Salary;

public interface SalaryDao {

	ArrayList<Salary> getAll(Connection conn)throws Exception;
}
