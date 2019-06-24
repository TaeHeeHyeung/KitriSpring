package com.kitri.cafe.board.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.cafe.board.service.BbsService;
import com.kitri.cafe.board.service.ReboardService;

@Controller
@RequestMapping("/reboard")
public class ReboardController {

	Logger logger = LoggerFactory.getLogger(ReboardController.class);
	
	@Autowired
	private ReboardService reboardService;
	
	
	@RequestMapping(value ="/write", method= RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter ,Model model) {
		logger.debug("write");
		model.addAttribute("parameter",parameter);
	}
}
