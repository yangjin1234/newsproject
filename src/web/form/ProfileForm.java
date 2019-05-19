package web.form;

import web.core.ActionForm;

public class ProfileForm extends ActionForm{
	private String user_name;
	private String user_sex;
	private String email;
	private String mobile;
	private String photo;
public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	//	private String pass1;
//	private String pass2;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getPass1() {
//		return pass1;
//	}
//	public void setPass1(String pass1) {
//		this.pass1 = pass1;
//	}
//	public String getPass2() {
//		return pass2;
//	}
//	public void setPass2(String pass2) {
//		this.pass2 = pass2;
//	}
}
