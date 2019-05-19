package web.form;

import web.core.ActionForm;

public class ProfileForm extends ActionForm{
	private String user_name;
	private String email;
	private String mobile;
	private String pass1;
	private String pass2;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUser_login() {
		return user_name;
	}
	public void setUser_login(String user_login) {
		this.user_name = user_login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
}
