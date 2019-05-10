package pojo;

import java.io.Serializable;

public class Login implements Serializable{

	private int lid;
	private String lname;
	private String lpass;
	private int lstate;
	@Override
	public String toString() {
		return "Login [lid=" + lid + ", lname=" + lname + ", lpass=" + lpass
				+ ", lstate=" + lstate + "]";
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpass() {
		return lpass;
	}
	public void setLpass(String lpass) {
		this.lpass = lpass;
	}
	public int getLstate() {
		return lstate;
	}
	public void setLstate(int lstate) {
		this.lstate = lstate;
	}
}
