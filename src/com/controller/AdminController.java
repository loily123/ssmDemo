package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Admin;
import com.exception.MyWebException;
import com.service.AdminService;

@Controller
public class AdminController {
	private Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;

	@RequestMapping("queryByUserName")
	public String queryByUserName(String userName, String password, HttpSession session) throws MyWebException {
		log.debug("进入adminController");
		log.debug("用户名为：" + userName + "，密码为：" + password);
		Admin admin = adminService.queryByUserName(userName, password);
		session.setAttribute("admin", admin);
		return "redirect:/jsp/adminMenu.jsp";
	}

	@RequestMapping("resetPassword")
	public String resetPassword(String confirmPassword, HttpSession session) {
		String userName = ((Admin) (session.getAttribute("admin"))).getUserName();
		log.debug("session中用户名：" + userName);
		adminService.updatePassword(userName, confirmPassword);
		session.invalidate();
		return "redirect:/jsp/adminLogin.jsp";
	}
}
