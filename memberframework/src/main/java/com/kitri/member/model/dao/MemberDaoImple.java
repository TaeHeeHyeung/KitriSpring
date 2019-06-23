package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kitri.member.model.*;
import com.kitri.sqlmap.MyBatisConfiguration;


@Repository
public class MemberDaoImple implements MemberDao {
	private final String NAME_SPACE ="com.kitri.member.model.dao.MemberDao";
	Logger logger = LoggerFactory.getLogger(MemberDaoImple.class);
	@Override
	public int idCheck(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".idCheck", id);
		} finally {
			session.close();
		}
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		SqlSession session =  MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectList(NAME_SPACE+".zipSearch", doro);
		}finally {
			session.close();
		}	
	}

	@Override
	public int registerMember(MemberDetailDto detailDto) {
		SqlSession session =  MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			session.insert(NAME_SPACE+".registerMember", detailDto);
			session.commit();
			return 1;
		}finally {
			session.close();
		}	
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		SqlSession session =  MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE+".loginMember", map);
		}finally {
			session.close();
		}	
	}

	@Override
	public MemberDetailDto getMember(String id) {
		SqlSession session =  MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE+".getMember", id);
		}finally {
			session.close();
		}	
	}

	@Override
	public int modifyMember(MemberDetailDto detailDto) {
		return 0;
	}

	@Override
	public int deleteMember(String memberid) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		int result =0;
		try {
			logger.info("memberid :"+memberid);
			result +=session.delete(NAME_SPACE+".deleteMember_Detail", memberid);
			result +=session.delete(NAME_SPACE+".deleteMember", memberid);
			session.commit();
			return result;
		}finally {
			session.close();
		}	
		
		
	}

	

}
