package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.kitri.member.model.*;
import com.kitri.sqlmap.MyBatisConfiguration;


@Repository
public class MemberDaoImple implements MemberDao {
	private final String NAME_SPACE ="com.kitri.member.model.dao.MemberDao";

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
	public MemberDetailDto getMember(int memberid) {
		SqlSession session =  MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE+".getMember", memberid);
		}finally {
			session.close();
		}	
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
