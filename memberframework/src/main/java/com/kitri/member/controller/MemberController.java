package com.kitri.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
@SessionAttributes("userInfo")
//@SessionAttributes(names= {"userInfo","b","c"})
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
//	@Qualifier("Impl1")
	private MemberService memberService;

	@RequestMapping(value = "/register.kitri", method = RequestMethod.GET)
	public String register() {
		return "user/member/member";
	}

	@RequestMapping(value = "/register.kitri", method = RequestMethod.POST)
	public String register(MemberDetailDto memberDetailDto, Model model) {
//		System.out.println(memberDetailDto.toString());
		int cnt = memberService.registerMember(memberDetailDto);
		if (cnt != 0) {
			model.addAttribute("registerInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/memberfail";
	}

	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)
//	@ResponseBody
	public @ResponseBody String idCheck(@RequestParam(name = "checkid", defaultValue = "") String id) {
		logger.info("검색 아이디:" + id);
		String json = memberService.idCheck(id);
		return json;
	}

	@RequestMapping(value = "/login.kitri")
	public String login() {
		return "user/login/login";
	}

//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST )
//	public String login(@RequestParam(name = "id") String id, @RequestParam(name="pass") String pass, HttpSession session) {
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		logger.info(memberDto.toString());
//		if(memberDto != null) {
//			logger.info(memberDto.toString());
//			session.setAttribute("userInfo", memberDto);
//			return "user/login/loginok";
//		}else {
//			return "user/login/loginfail";
//		}
//	}
	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
//	@RequestParam 을 Map 앞에 안써주면 다음 url로 넘겨줄 변수가 된다.
	public String login(@RequestParam Map<String, String> map, Model model) {// ,HttpSession session,
		MemberDto memberDto = memberService.loginMember(map);
		if (memberDto != null) {
			model.addAttribute("userInfo", memberDto); // 스프링 세션에 값이 들어간다.
			logger.info(memberDto.toString());
//			session.setAttribute("userInfo", memberDto);
			return "user/login/loginok";
		} else {
			return "user/login/loginfail";
		}

	}

	@RequestMapping(value = "/zipsearch.kitri")
	@ResponseBody
	public String zipSearch(@RequestParam("doro") String doro) {
		logger.info(doro);
		String json = memberService.zipSearch(doro);
		return json;
	}

//	@RequestMapping(value="/logout.kitri")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");		
//		return "redirect:/index.jsp";
//	}

	@RequestMapping(value = "/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus sessionStatus) {// MemberDto memberDto
		sessionStatus.setComplete();
		return "redirect:/index.jsp";

	}

}// end MemberController
