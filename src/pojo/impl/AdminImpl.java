package pojo.impl;

public class AdminImpl {
	private int aid; // 主键
	private String aname; // 账号
	private String apass; // 密码
	private String aphone; // 手机号码
	private int astate; // 用户状态
	private int acheck; // 审核状态
	private int admin_type; // 管理员类型
	private String admin_email;
	@Override
	public String toString() {
		return "AdminImpl [aid=" + aid + ", aname=" + aname + ", apass="
				+ apass + ", aphone=" + aphone + ", astate=" + astate
				+ ", acheck=" + acheck + ", admin_type=" + admin_type
				+ ", admin_email=" + admin_email + ", admin_answer="
				+ admin_answer + ", admin_question=" + admin_question
				+ ", admin_code=" + admin_code + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
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
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_answer() {
		return admin_answer;
	}
	public void setAdmin_answer(String admin_answer) {
		this.admin_answer = admin_answer;
	}
	public String getAdmin_question() {
		return admin_question;
	}
	public void setAdmin_question(String admin_question) {
		this.admin_question = admin_question;
	}
	public String getAdmin_code() {
		return admin_code;
	}
	public void setAdmin_code(String admin_code) {
		this.admin_code = admin_code;
	}
	private String  admin_answer;
	private String  admin_question;
	private String admin_code;

}
