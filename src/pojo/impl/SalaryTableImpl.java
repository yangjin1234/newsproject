package pojo.impl;

import java.io.Serializable;
import java.sql.Timestamp;

public class SalaryTableImpl implements Serializable{
	private int salarys_state;
	private int sid;
	public int getSalarys_state() {
		return salarys_state;
	}
	public void setSalarys_state(int salarys_state) {
		this.salarys_state = salarys_state;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "SalaryTableImpl [salarys_state=" + salarys_state + ", sid="
				+ sid + ", sid_uid_key=" + sid_uid_key + ", sdate=" + sdate
				+ ", salarys=" + salarys + ", username=" + username + "]";
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
	public double getSalarys() {
		return salarys;
	}
	public void setSalarys(double salarys) {
		this.salarys = salarys;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private int sid_uid_key;
	private Timestamp  sdate;
	private double salarys;
	private String username;
	

}
