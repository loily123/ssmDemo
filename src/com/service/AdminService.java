package com.service;

import com.entity.Admin;
import com.exception.MyWebException;

public interface AdminService {
	Admin queryByUserName(String userName, String password) throws MyWebException;

	void updatePassword(String userName, String password);
}
