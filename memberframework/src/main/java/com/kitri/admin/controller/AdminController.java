package com.kitri.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.admin.model.service.AdminService;
import com.kitri.admin.model.service.AdminServiceImple;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;

	@RequestMapping("/mvmemberlist.kitri")
	public String mvmemberlist() {
		return "admin/member/memberlist";
	}
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
	@RequestMapping(value ="/memberlist.kitri" ,method = RequestMethod.GET)
	@ResponseBody
	public String memberlist(@RequestParam Map<String, String> map) { 
		System.out.println(map.toString());
		logger.info(map.toString());
		String json = service.getMemberList(map);
		logger.info(json);
		return json;
	}
	
}
