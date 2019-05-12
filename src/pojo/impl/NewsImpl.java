package pojo.impl;

import pojo.News;

public class NewsImpl extends News{

	private String uname;
	private String typename;

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}
