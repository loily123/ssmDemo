package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Admin;
import com.exception.MyWebException;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.util.ErrorCode;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	private Logger log = Logger.getLogger(AdminServiceImpl.class);

	@Override
	public Admin queryByUserName(String userName, String password) throws MyWebException {
		// TODO Auto-generated method stub
		log.debug("进入adminServiceImpl");
		List<Admin> admins = adminMapper.queryByUserName(userName);
		log.debug(admins.size());
		if (admins.size() == 0) {
			throw new MyWebException("用户不存在", ErrorCode.USERNOTEXIST);
		} else if (!password.equals(admins.get(0).getPassword())) {
			throw new MyWebException("密码不正确", ErrorCode.PASSWORDERROR);
		}
		return admins.get(0);
	}

	@Override
	@Transactional
	public void updatePassword(String userName, String password) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", userName);
		map.put("password", password);
		adminMapper.updatePassword(map);
	}
}
