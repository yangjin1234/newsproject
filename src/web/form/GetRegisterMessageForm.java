package web.form;

import util.MyLog;
import web.core.ActionForm;

public class GetRegisterMessageForm extends ActionForm{
	private String data;

	public String getData() {
		MyLog.log.debug("bb");
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
