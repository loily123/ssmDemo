package com.mapper;

import java.util.List;
import java.util.Map;

import com.entity.Admin;

public interface AdminMapper {
	List<Admin> queryByUserName(String userName);

	void updatePassword(Map<String, String> map);
}
