package service;

import java.sql.Connection;

import pojo.impl.Userinformation;

public interface UserInformationService {
	public Userinformation selectUserByName(String uname);
}
