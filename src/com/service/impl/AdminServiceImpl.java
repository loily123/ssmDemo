package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.exception.MyWebException;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.util.ErrorCode;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin queryByUserName(String userName, String password) throws MyWebException {
		// TODO Auto-generated method stub
		List<Admin> admins = adminMapper.queryByUserName(userName);
		if (admins.size() == 0) {
			throw new MyWebException("用户不存在", ErrorCode.USERNOTEXIST);
		} else if (!password.equals(admins.get(0))) {
			throw new MyWebException("密码不正确", ErrorCode.PASSWORDERROR);
		}
		return admins.get(0);
	}

}
