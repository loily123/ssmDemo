package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Admin;
import com.exception.MyWebException;
import com.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping("queryByUserName")
	public String queryByUserName(String userName, String password, HttpSession session, HttpServletRequest request)
			throws MyWebException {
		Admin admin = adminService.queryByUserName(userName, password);
		session.setAttribute("admin", admin);
		return "redirect:jsp/adminMenu.jsp";

	}
}
