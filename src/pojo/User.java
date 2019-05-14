package pojo;

import java.io.Serializable;

import util.MyLog;

public class User implements Serializable{
	private String user_pwd1;
	private String username;
	private String user_email;
	private String  user_answer;
	private String user_question;
	public String getUser_pwd1() {
		return user_pwd1;
	}
	public void setUser_pwd1(String user_pwd1) {
		this.user_pwd1 = user_pwd1;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public String getUser_question() {
		return user_question;
	}
	public void setUser_question(String user_question) {
		this.user_question = user_question;
	}
	public String toString() {
		return "User [user_pwd1=" + user_pwd1 + ", username=" + username
				+ ", user_email=" + user_email + ", user_answer=" + user_answer
				+ ", user_question=" + user_question + "]";
	}
	

}
