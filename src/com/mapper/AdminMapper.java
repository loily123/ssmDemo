package com.mapper;

import java.util.List;

import com.entity.Admin;

public interface AdminMapper {
	List<Admin> queryByUserName(String userName);
}
