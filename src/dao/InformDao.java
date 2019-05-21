package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Inform;

public interface InformDao {
		public List<Inform> selectInform(Connection conn)throws Exception;
		public boolean insertOneInform(Connection conn,Inform inform)throws Exception;
}
