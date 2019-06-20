package com.kitri.member.model.service;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.member.controller.MemberController;
import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	MemberDao memberDao;
	
	@Override
	public String idCheck(String id) {
		int cnt = memberDao.idCheck(id);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);
		return json.toString();
	}

	@Override
	public String zipSearch(String doro) {
		List<ZipcodeDto> list = memberDao.zipSearch(doro);
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray= new JSONArray(list);
		logger.info(list.toString());
		
//		for (ZipcodeDto dto: list) {
//			JSONObject dtojson = new JSONObject();
			
//			dtojson.put("zipcode", dto.getZipcode());
//			logger.info("address:"+ dto.getSido()+" "+dto.getGugun()+" "+dto.getUpmyon()+" "+dto.getBuilding_number()+" "+dto.getSigugun_building_name());
//			dtojson.put("address", dto.getSido()+" "+dto.getGugun()+" "+dto.getUpmyon()+" "+dto.getBuilding_number()+" "+dto.getSigugun_building_name());
//			jsonArray.put(dtojson);
//		}
		jsonObj.put("ziplist", jsonArray);
		return jsonObj.toString();
	}
	
//	{"ziplist", [{"zipcode", :"12345", "address":"서울시..", "addressdetail": "405호"} ,
//	            {"zipcode", :"12345", "address":"서울시..", "addressdetail": "405호"} ]}

	@Override
	public int registerMember(MemberDetailDto detailDto) {
		return memberDao.registerMember(detailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return memberDao.loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(int memberid) {
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto detailDto) {
		return 0;
	}

	@Override
	public int deleteMember(int memberid) {
		return 0;
	}

}
