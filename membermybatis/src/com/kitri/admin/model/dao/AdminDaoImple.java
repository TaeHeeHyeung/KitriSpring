package com.kitri.admin.model.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.sqlmap.MyBatisConfiguration;

public class AdminDaoImple implements AdminDao {
	
	private final String NAME_SPACE ="com.kitri.admin.model.dao.AdminDao";
	private static AdminDaoImple adminDaoImple;

	static {
		adminDaoImple = new AdminDaoImple();
	}

	private AdminDaoImple() {
	}

	public static AdminDaoImple getAdminDao() {
		return adminDaoImple;
	}

	@Override
	public List<MemberDetailDto> getMemberList(Map<String, String> map) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".getMemberList", map);
		} finally {
			session.close();
		}
	}

}
