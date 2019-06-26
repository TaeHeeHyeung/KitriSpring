package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.dao.ReboardDao;
import com.kitri.cafe.board.model.ReboardDto;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;

@Service
public class ReboardServiceImple implements ReboardService {

	Logger logger = LoggerFactory.getLogger(ReboardServiceImple.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int cnt = sqlSession.getMapper(ReboardDao.class).writeArticle(reboardDto);
		return cnt!=0 ? reboardDto.getSeq(): 0;
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> parameter) {
		int pg = NumberCheck.NotNumberToOne(parameter.get("pg"));
		
		int end = pg*CafeConstance.ARTICLE_SIZE;
		int start = end -CafeConstance.ARTICLE_SIZE;
		
		parameter.put("start", start+"");
		parameter.put("end", end+"");
		
		return sqlSession.getMapper(ReboardDao.class).listArticle(parameter);
	}

	@Override
	public ReboardDto viewArticle(int seq) {
	//에디터 쓰게되면 필요 없게된다.
		ReboardDto reboardDto = sqlSession.getMapper(ReboardDao.class).viewArticle(seq);
		String content = reboardDto.getContent().replace("\n", "<br>");
		reboardDto.setContent(content);
		logger.debug(content);
//		System.out.println(content);
		return reboardDto;
		
	} 

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {
		// TODO Auto-generated method stub

	}

}
