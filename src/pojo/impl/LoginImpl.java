package pojo.impl;

import java.io.Serializable;

public class LoginImpl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lname;
	private String lpass;
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
}
