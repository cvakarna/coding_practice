package com.services;

import com.dao.UserDAO;
import com.dao.Impl.UserDAOImpl;

public class UserService {

	UserDAO dao;

	public UserService() {
		dao=new UserDAOImpl();
	}

	public void getUser() {
		dao.getUserById();
	}

}
