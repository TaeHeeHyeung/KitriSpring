package com.kitri.cafe.common.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kitri.cafe.util.PageNavigation;

public interface CommonService {
	
	
	public int getNextSeq();
	
	PageNavigation getPageNavigation(Map<String,String> parameter);
	
}
