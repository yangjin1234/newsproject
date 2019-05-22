package pojo.impl;

public class AdminImpl {
	
	
	private int aid; // 主键
	private String username; // 账号
	private String user_pwd1; // 密码
	private String aphone; // 手机号码
	private int astate; // 用户状态
	private int acheck; // 审核状态
	private int admin_type; // 管理员类型
	private String user_email;//邮件
	private String  user_answer;
	private String  user_question;
	private String user_code;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_pwd1() {
		return user_pwd1;
	}
	public void setUser_pwd1(String user_pwd1) {
		this.user_pwd1 = user_pwd1;
	}
	public String getAphone() {
		return aphone;
	}
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}
	public int getAstate() {
		return astate;
	}
	public void setAstate(int astate) {
		this.astate = astate;
	}
	public int getAcheck() {
		return acheck;
	}
	public void setAcheck(int acheck) {
		this.acheck = acheck;
	}
	public int getAdmin_type() {
		return admin_type;
	}
	public void setAdmin_type(int admin_type) {
		this.admin_type = admin_type;
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
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	@Override
	public String toString() {
		return "AdminImpl [aid=" + aid + ", username=" + username
				+ ", user_pwd1=" + user_pwd1 + ", aphone=" + aphone
				+ ", astate=" + astate + ", acheck=" + acheck + ", admin_type="
				+ admin_type + ", user_email=" + user_email + ", user_answer="
				+ user_answer + ", user_question=" + user_question
				+ ", user_code=" + user_code + "]";
	}
	
	

}
