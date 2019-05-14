package pojo;

import java.io.Serializable;

public class UpdatePass implements Serializable{
	private String username;
	private String user_question;
	private String user_answer;
	private String user_pwd1;
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
	public String getUser_question() {
		return user_question;
	}
	public void setUser_question(String user_question) {
		this.user_question = user_question;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public String toString() {
		return "UpdatePass [username=" + username + ", user_question="
				+ user_question + ", user_answer=" + user_answer
				+ ", user_pwd1=" + user_pwd1 + "]";
	}

}
