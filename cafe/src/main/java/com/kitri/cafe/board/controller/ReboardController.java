package com.kitri.cafe.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.cafe.board.model.ReboardDto;
import com.kitri.cafe.board.service.BbsService;
import com.kitri.cafe.board.service.ReboardService;
import com.kitri.cafe.common.service.CommonService;
import com.kitri.cafe.member.model.MemberDto;
import com.kitri.cafe.util.NumberCheck;
import com.kitri.cafe.util.PageNavigation;



//Controller는 요청과 응답을 처리한다.
@Controller
@RequestMapping("/reboard")
public class ReboardController {

	Logger logger = LoggerFactory.getLogger(ReboardController.class);

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ReboardService reboardService;
	
	//답장 페이지로 이동
	@RequestMapping(value ="/reply", method= RequestMethod.GET)
	public String reply(@RequestParam Map<String, String> parameter,@RequestParam(name= "seq")int seq, 
			Model model,HttpSession session) {
		
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		
		String path ="";
		if(memberDto !=null) {
			ReboardDto reboardDto = reboardService.getArticle(seq);
			model.addAttribute("article", reboardDto);
			model.addAttribute("parameter", parameter);
			logger.debug(reboardDto.toString());
			path= "reboard/reply";
		}else {
			path= "redirect:/index.jsp"; 
		} 
		return path;
	}
	
	@RequestMapping(value ="/list", method= RequestMethod.GET)
	public void list (@RequestParam Map<String, String> parameter, Model model, HttpServletRequest request) {
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		System.out.println(parameter.toString());
		List<ReboardDto> list = reboardService.listArticle(parameter);
		PageNavigation pageNavigation = commonService.getPageNavigation(parameter);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.makeNavigator();
		
		model.addAttribute("parameter", parameter);
		model.addAttribute("articleList", list);
		model.addAttribute("navigator",pageNavigation );
		
	}
	
	@RequestMapping(value ="/view", method= RequestMethod.GET)
	public String view(@RequestParam(name= "seq")int seq, @RequestParam Map<String, String> parameter ,Model model, HttpSession session) {
//		System.out.println("reboard view");
//		logger.debug("reboard view");
		
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path ="";
		if(memberDto !=null) {
			ReboardDto reboardDto = reboardService.viewArticle(seq);
			model.addAttribute("article", reboardDto);
			model.addAttribute("parameter", parameter);
			logger.debug(reboardDto.toString());
			path= "reboard/view";
		}else {
			path= "redirect:/index.jsp"; 
		} 
		return path;
	}//end view
	
	//글쓰기 단순 페이지이동
	@RequestMapping(value ="/write", method= RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter ,Model model) {
		model.addAttribute("parameter", parameter);
	}
	
	@RequestMapping(value ="/write", method= RequestMethod.POST)
	public String write(ReboardDto reboardDto, @RequestParam Map<String, String> parameter ,Model model
			,HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path ="";
		
		if(memberDto!=null) {
			int seq = commonService.getNextSeq();
			logger.debug("ReboardController getNextSeq: "+"seq");
			System.out.println("ReboardController getNextSeq: "+"seq");
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail());
			reboardDto.setRef(seq);
			
			seq = reboardService.writeArticle(reboardDto);
			if(seq !=0) {
				model.addAttribute("seq", seq);
				path ="reboard/writeok";
			}else {
				path="reboard/writefail";
			}
			
			logger.debug(">>"+seq);
			logger.debug(reboardDto.toString());
			System.out.println(">>"+seq);
			model.addAttribute("parameter", parameter);
			return path;	
		}else {
			path= "redirect:/index.jsp"; 
			logger.debug("memberDto is null");
			System.out.println("memberDto is null");
			System.out.println("로그인해주세요");
			return path;
		}
		
	}//end write

	//답장 쓰기
	@RequestMapping(value ="/reply", method= RequestMethod.POST)
	public String reply(ReboardDto reboardDto, @RequestParam Map<String, String> parameter,
			Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path ="";
//		System.out.println("pseq는???"+parameter.get("pseq")); 
		if(memberDto!=null) {
			int seq = commonService.getNextSeq();
//			logger.debug("ReboardController getNextSeq: "+seq);
//			System.out.println("ReboardController getNextSeq: "+seq);
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail());
			reboardDto.setPseq(NumberCheck.NotNumberToOne(parameter.get("pseq")));
			
			seq = reboardService.replyArticle(reboardDto);
			if(seq !=0) {
				model.addAttribute("seq", seq);
				path ="reboard/writeok";
			}else {
				path="reboard/writefail";
			}
			
			logger.debug(">>"+seq);
			logger.debug(reboardDto.toString());
			System.out.println(">>"+seq);
			model.addAttribute("parameter", parameter);
			return path;	
		}else {
			path= "redirect:/index.jsp";
			
			logger.debug("memberDto is null");
			System.out.println("memberDto is null");
			System.out.println("로그인해주세요");
			return path;
		}
	}//end reply
}

