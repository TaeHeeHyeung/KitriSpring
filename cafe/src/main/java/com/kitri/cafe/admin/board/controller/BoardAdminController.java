package com.kitri.cafe.admin.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.service.BoardAdminService;

@Controller
@RequestMapping("/boardadmin")
public class BoardAdminController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardAdminController.class);
	
	@Autowired
	BoardAdminService boardAdminService;
	
	@RequestMapping("/boardmenu")
	public ModelAndView boardMenu(@RequestParam(name="ccode", defaultValue = "0") int ccode) {
		List<BoardListDto> list = boardAdminService.getBoardMenuList(ccode);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardmenu",list);
		mav.setViewName("admin/boardmenu");
		
		logger.info("cname:"+list.get(1).getCname());
		logger.info("bname:"+list.get(1).getBname());
		logger.info("listsize :"+list.size());
		return mav;
	}

	
}
