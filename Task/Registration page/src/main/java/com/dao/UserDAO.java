package com.dao;

import com.models.User;

public interface UserDAO {

	public boolean insert(User user);
	public  User getUserById();
}
