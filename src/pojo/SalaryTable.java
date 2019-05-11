package pojo;

import java.io.Serializable;
import java.sql.Timestamp;



public class SalaryTable implements Serializable{
	private int salarys_state;
	private int sid;
	private int sid_uid_key;
	private Timestamp  sdate;
	private double salarys;
	public int getSalarys_state() {
		return salarys_state;
	}
	@Override
	public String toString() {
		return "SalaryTable [salarys_state=" + salarys_state + ", sid=" + sid
				+ ", sid_uid_key=" + sid_uid_key + ", sdate=" + sdate
				+ ", salarys=" + salarys + "]";
	}
	public void setSalarys_state(int salarys_state) {
		this.salarys_state = salarys_state;
	}
	public double getSalarys() {
		return salarys;
	}
	public void setSalarys(double salarys) {
		this.salarys = salarys;
	}
//	public String getSdate() {
//		return sdate;
//	}
//	public void setSdate(String sdate) {
//		this.sdate = sdate;
//	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSid_uid_key() {
		return sid_uid_key;
	}
	public void setSid_uid_key(int sid_uid_key) {
		this.sid_uid_key = sid_uid_key;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}
	
	


}
