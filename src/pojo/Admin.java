package pojo;

public class Admin {

	private int aid; // 主键
	private String aname; // 账号
	private String apass; // 密码
	private String aphone; // 手机号码
	private int astate; // 用户状态
	private int acheck; // 审核状态
	private int admin_type; // 管理员类型

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

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", apass=" + apass
				+ ", aphone=" + aphone + ", astate=" + astate + ", acheck="
				+ acheck + ", admin_type=" + admin_type + "]";
	}
}
