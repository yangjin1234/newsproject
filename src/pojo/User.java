package pojo;

import java.io.Serializable;

import util.MyLog;

public class User implements Serializable{
	
	private String upass;
	private String uname;
	private String uemail;
	private String  uanwer;
	private String uquestion;
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUanwer() {
		MyLog.log.debug("kk");
		return uanwer;
	}
	
	
	public String toString() {
		return "User [upass=" + upass + ", uname=" + uname + ", uemail="
				+ uemail + ", uanwer=" + uanwer + ", uquestion=" + uquestion
				+ "]";
	}
	public void setUanwer(String uanwer) {
		this.uanwer = uanwer;
	}
	public String getUquestion() {
		return uquestion;
	}
	public void setUquestion(String uquestion) {
		this.uquestion = uquestion;
	}

}
