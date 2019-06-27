package com.kitri.cafe.common.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kitri.cafe.common.dao.CommonDao;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;
import com.kitri.cafe.util.PageNavigation;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SqlSession SqlSession;
	
	
	
	
	@Override
	public int getNextSeq() {
		return SqlSession.getMapper(CommonDao.class).getNextSeq();
	}

	@Override
	public PageNavigation getPageNavigation(Map<String, String> parameter) {
		PageNavigation navigation = new PageNavigation();
		int newArticleCount = SqlSession.getMapper(CommonDao.class).getNewArticleCount(Integer.parseInt(parameter.get("bcode")));
		navigation.setNewArticleCount(newArticleCount);
		int totalArticleCount =  SqlSession.getMapper(CommonDao.class).getTotalArticleCount(parameter);
		navigation.setTotalArticleCount(totalArticleCount);
		
		int totalPageCount = (totalArticleCount-1) / CafeConstance.ARTICLE_SIZE + 1;
		navigation.setTotalPageCount(totalPageCount);
		int pg = NumberCheck.NotNumberToOne(parameter.get("pg"));
		navigation.setNowFirst((pg <=CafeConstance.PAGE_SIZE));
//		int endCnt  = totalPageCount-1 /CafeConstance.PAGE_SIZE;  //10 11 12 13 14... 19 나누어 떨어지는게 문제 
//		int myCnt = pg/CafeConstance.PAGE_SIZE; 
//		boolean nowEnd = true;
//		if(endCnt > myCnt) {  
//			nowEnd= false;
//		}
		boolean nowEnd = ( (totalPageCount-1) /CafeConstance.PAGE_SIZE * CafeConstance.PAGE_SIZE<pg); 
		navigation.setNowEnd(nowEnd);
		navigation.setPageNo(pg);
		
		
		return navigation;
	}




}
