package pojo;

import java.io.Serializable;

public class User implements Serializable{

	private int uid;
	private int uid_lid_key;
	private String uname;
	private String usex;
	private String uemail;
	private String uphone;
	private int ustate;
	private String uphoto;
	private int uid_sid_key;
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uid_lid_key=" + uid_lid_key + ", uname="
				+ uname + ", usex=" + usex + ", uemail=" + uemail + ", uphone="
				+ uphone + ", ustate=" + ustate + ", uphoto=" + uphoto
				+ ", uid_sid_key=" + uid_sid_key + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid_lid_key() {
		return uid_lid_key;
	}
	public void setUid_lid_key(int uid_lid_key) {
		this.uid_lid_key = uid_lid_key;
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
	public int getUid_sid_key() {
		return uid_sid_key;
	}
	public void setUid_sid_key(int uid_sid_key) {
		this.uid_sid_key = uid_sid_key;
	}
}
