package web.form;

import web.core.ActionForm;

public class LoginForm extends ActionForm{
	private String lname;
	private String lpass;
	private String rememberme;
	private String redirect_to;
	private String testcookie;
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
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
	public String getRememberme() {
		return rememberme;
	}
	public void setRememberme(String rememberme) {
		this.rememberme = rememberme;
	}
	public String getRedirect_to() {
		return redirect_to;
	}
	public void setRedirect_to(String redirectTo) {
		redirect_to = redirectTo;
	}
	public String getTestcookie() {
		return testcookie;
	}
	public void setTestcookie(String testcookie) {
		this.testcookie = testcookie;
	}
	
}
