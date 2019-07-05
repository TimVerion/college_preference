package com.project.service;

import java.sql.SQLException;
import java.util.List;

import com.project.domain.User;

public interface UserService {

	void regist(User user) throws Exception;

	User active(String code) throws Exception;

	User login(String username, String password) throws Exception;

	List<User> findAll();

}
