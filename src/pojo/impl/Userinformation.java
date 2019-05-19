package pojo.impl;

import java.io.Serializable;

public class Userinformation implements Serializable{
	public Userinformation() {
	}
	private int uid;
	private String uname;
	private String usex;
	private String uemail;
	private String uphone;
	private int ustate;
	private String uphoto;
	private String uproblem;
	private String uanswer;
	private int uid_lid_key;
	private int uid_sid_key;
	public int getUid_lid_key() {
		return uid_lid_key;
	}
	public void setUid_lid_key(int uidLidKey) {
		uid_lid_key = uidLidKey;
	}
	public int getUid_sid_key() {
		return uid_sid_key;
	}
	public void setUid_sid_key(int uidSidKey) {
		uid_sid_key = uidSidKey;
	}
	public String getUproblem() {
		return uproblem;
	}
	public void setUproblem(String uproblem) {
		this.uproblem = uproblem;
	}
	public String getUanswer() {
		return uanswer;
	}
	public void setUanswer(String uanswer) {
		this.uanswer = uanswer;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
}
