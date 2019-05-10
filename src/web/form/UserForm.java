package web.form;

import web.core.ActionForm;

public class UserForm extends ActionForm{

	private String uname;
	private String upass;
	private String wp_submit;
	private String rememberme;
	public String getRememberme() {
		return rememberme;
	}
	public void setRememberme(String rememberme) {
		this.rememberme = rememberme;
	}
	public String getWp_submit() {
		return wp_submit;
	}
	public void setWp_submit(String wp_submit) {
		this.wp_submit = wp_submit;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
}
