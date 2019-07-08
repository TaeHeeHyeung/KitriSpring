package com.kitri.cafe.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kitri.cafe.board.model.MemoDto;
import com.kitri.cafe.board.service.MemoService;
import com.kitri.cafe.member.model.MemberDto;

//@Controller
@RestController
@RequestMapping("/memo")
public class MemoController {

	Logger logger = LoggerFactory.getLogger(MemoController.class);

	@Autowired
	private MemoService memoService;

	//, consumes = MediaType.APPLICATION_JSON_VALUE 무조건 contenttype이 json인것만 호출한다.
	// requestbody : json을 넣어줄 때
//	@RequestBody 'application/json;charset=UTF-8' not supported (pom.xml에 jackson library 필요
//	@ResponseBody // json을 넘겨줄 때) -> @RestController 를 사용하고 생략
	@RequestMapping(method = RequestMethod.POST)
	public String write(@RequestBody MemoDto memoDto, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
			logger.info(memoDto.toString());
			System.out.println(memoDto.toString());
			memoService.writeMemo(memoDto);
			String json = memoService.listMemo(memoDto.getSeq());
			return json;
		}
		return "";
	}
//	, consumes = MediaType.APPLICATION_JSON_VALUE
//	@ResponseBody // json을 넘겨줄 때 , ->restController 
	@RequestMapping(method = RequestMethod.GET)
	public String list(int seq) {
		String json = memoService.listMemo(seq);
		return json;
	}
	
//	
	@RequestMapping(value="/{seq}/{mseq}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public String delete(@PathVariable(name="seq") int seq,@PathVariable(name="mseq")int mseq 
			,@RequestBody Map<String, String> parameter) {
		logger.debug(parameter.get("sseq"));
		String json= memoService.deleteMemo(seq, mseq);
		return json;
	}
}
