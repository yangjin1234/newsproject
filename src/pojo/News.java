package pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class News implements Serializable{
	@Override
	public String toString() {
		return "News [nid=" + nid + ", nid_uid_key=" + nid_uid_key + ", title="
				+ title + ", ncontent=" + ncontent + ", news_state="
				+ news_state + ", nsalary=" + nsalary + ", nupload_time="
				+ nupload_time + ", namend_time=" + namend_time
				+ ", nsalarsy_state=" + nsalary_state + ", nid_tid_key="
				+ nid_tid_key + "]";
	}
	private int nid;
	private int nid_uid_key;
	private String title;
	private String ncontent;
	private int news_state;
	private double nsalary;
	private Timestamp nupload_time;
	private Timestamp namend_time;
	private int nsalary_state ;
	private int nid_tid_key;
	public int getNid_sid_key() {
		return nid_sid_key;
	}
	public void setNid_sid_key(int nid_sid_key) {
		this.nid_sid_key = nid_sid_key;
	}
	private int nid_sid_key;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNid_uid_key() {
		return nid_uid_key;
	}
	public void setNid_uid_key(int nid_uid_key) {
		this.nid_uid_key = nid_uid_key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public int getNews_state() {
		return news_state;
	}
	public void setNews_state(int news_state) {
		this.news_state = news_state;
	}
	public double getNsalary() {
		return nsalary;
	}
	public void setNsalary(double nsalary) {
		this.nsalary = nsalary;
	}
	public Timestamp getNupload_time() {
		return nupload_time;
	}
	public void setNupload_time(Timestamp nupload_time) {
		this.nupload_time = nupload_time;
	}
	public Timestamp getNamend_time() {
		return namend_time;
	}
	public void setNamend_time(Timestamp namend_time) {
		this.namend_time = namend_time;
	}
	public int getNsalary_state() {
		return nsalary_state;
	}
	public void setNsalary_state(int nsalary_state) {
		this.nsalary_state = nsalary_state;
	}
	public int getNid_tid_key() {
		return nid_tid_key;
	}
	public void setNid_tid_key(int nid_tid_key) {
		this.nid_tid_key = nid_tid_key;
	}

}
