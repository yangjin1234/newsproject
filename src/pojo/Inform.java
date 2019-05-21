package pojo;

import java.io.Serializable;
import java.util.Date;

public class Inform implements Serializable{
	private int iid;
	private String ititle;
	private String icontent;
	private Date itime;
	private int istate;
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getItitle() {
		return ititle;
	}
	public void setItitle(String ititle) {
		this.ititle = ititle;
	}
	public String getIcontent() {
		return icontent;
	}
	public void setIcontent(String icontent) {
		this.icontent = icontent;
	}
	public Date getItime() {
		return itime;
	}
	public void setItime(Date itime) {
		this.itime = itime;
	}
	public int getIstate() {
		return istate;
	}
	public void setIstate(int istate) {
		this.istate = istate;
	}
}
