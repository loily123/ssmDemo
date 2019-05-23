package com.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
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
	private Logger log = Logger.getLogger(AdminServiceImpl.class);

	@Override
	public Admin queryByUserName(String userName, String password) throws MyWebException {
		// TODO Auto-generated method stub
		log.debug("����adminServiceImpl");
		List<Admin> admins = adminMapper.queryByUserName(userName);
		if (admins.size() == 0) {
			throw new MyWebException("�û�������", ErrorCode.USERNOTEXIST);
		} else if (!password.equals(admins.get(0))) {
			throw new MyWebException("���벻��ȷ", ErrorCode.PASSWORDERROR);
		}
		return admins.get(0);
	}

}
