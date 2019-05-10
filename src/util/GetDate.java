package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 得到一个时间
 * @author yangjin
 *
 */
public class GetDate {

	/**
	 * 获得String类型的当前时间
	 * @return
	 */
	public static String getNowDate(){
		final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		String time=sdf.format(d);
//		MyLog.log.debug(d);
		return time;
	}
	
	/**
	 * 通过String类型的时间得到Timestamp类型的时间
	 * @param time
	 * @return
	 */
	public static Timestamp getNowDate2(String time){
		final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {

			date=sdf.parse(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp d=new Timestamp(date.getTime());
		return d;
	}
	public static void main(String[] args) {
		String time=getNowDate();
		System.out.println(time);
		String time2="2019-05-05";
		System.out.println( GetDate.getNowDate2(time));
	}
}
