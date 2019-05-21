package dao;

import java.sql.Connection;

import pojo.Inform;

public interface InformDao {
		public Inform selectInform(Connection conn)throws Exception;
		
}
