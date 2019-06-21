package com.kitri.admin.model.service;

import java.util.*;


import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.admin.model.dao.AdminDao;
import com.kitri.admin.model.service.AdminService;
import com.kitri.member.model.MemberDetailDto;

@Service
public class AdminServiceImple implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImple.class);
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public String getMemberList(Map<String,String> map) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("key", key);
//		map.put("word", word);
		JSONObject json = new JSONObject();
		JSONArray jsonArry = new JSONArray();
		
		logger.info(map.get("key"));
		logger.info(map.get("word"));
//		System.out.println(map.get("key")+" "+map.get("word"));
		List<MemberDetailDto> list = adminDao.getMemberList(map);
		logger.debug(list.toString());
		System.out.println(list.toString());
		jsonArry.put(list);
		
		json.put("memberlist", jsonArry);
		
//		String result = "<?xml version =\"1.0\" encoding=\"utf-8\"?>\n";
//		result += "<memberlist>\n";
//		for (MemberDetailDto memberDetailDto : list) {
//			result += "	<member>\n";
//			result += "		<id>"+memberDetailDto.getId()+"</id>\n";
//			result += "		<name>"+memberDetailDto.getName()+"</name>\n";
//			result += "		<email>"+memberDetailDto.getEmailid()+"@"+memberDetailDto.getEmaildomain()+"</email>\n";
//			result += "		<tel>"+memberDetailDto.getTel1()+"-"+memberDetailDto.getTel1()+"-"+ "</tel>\n";
//			result += "		<address><![CDATA["+memberDetailDto.getAddress()+" "+ memberDetailDto.getAddressDetail()+"]]></address>\n";
//			result += "		<joindate>"+memberDetailDto.getJoindate()+"</joindate>\n";
//			result += "	</member>\n";
//		}
//		result += "</memberlist>\n";
		
//		System.out.println(result);
		return json.toString();
	}

}
