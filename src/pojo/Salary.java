package pojo;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable{

	@Override
	public String toString() {
		return "Salary [sid=" + sid + ", sid_uid_key=" + sid_uid_key
				+ ", sdate=" + sdate + ", salarys=" + salarys
				+ ", salarys_state=" + salarys_state + "]";
	}
	private int sid;
	private int sid_uid_key;
	private Date sdate;
	private double salarys;
	private int salarys_state;
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
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public double getSalarys() {
		return salarys;
	}
	public void setSalarys(double salarys) {
		this.salarys = salarys;
	}
	public int getSalarys_state() {
		return salarys_state;
	}
	public void setSalarys_state(int salarys_state) {
		this.salarys_state = salarys_state;
	}
}
