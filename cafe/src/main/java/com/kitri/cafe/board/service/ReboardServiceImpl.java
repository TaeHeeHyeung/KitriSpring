package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kitri.cafe.board.dao.ReboardDao;
import com.kitri.cafe.board.model.ReboardDto;
import com.kitri.cafe.common.dao.CommonDao;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;

//DB에서 받은 내용을 가공 전달한다. (처리작업)
@Service
public class ReboardServiceImpl implements ReboardService {

	Logger logger = LoggerFactory.getLogger(ReboardServiceImpl.class);
	
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

	//transactional -> rootcontext transactionmanager
	@Override
	@Transactional 
	public ReboardDto viewArticle(int seq) {
		sqlSession.getMapper(CommonDao.class).updateHit(seq);
		//에디터 쓰게되면 필요 없게된다.
		ReboardDto reboardDto = sqlSession.getMapper(ReboardDao.class).viewArticle(seq);
		String content = reboardDto.getContent().replace("\n", "<br>");
		reboardDto.setContent(content);
		logger.debug(content);
		return reboardDto;
	} 
	@Override
	@Transactional 
	public ReboardDto getArticle(int seq) {
		return sqlSession.getMapper(ReboardDao.class).viewArticle(seq);
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

	@Override
	@Transactional
	public int replyArticle(ReboardDto reboardDto) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		reboardDao.updateStep(reboardDto);
//		System.out.println("ReboardServiceImple: replyupdateStep ok");
		reboardDao.replyArticle(reboardDto);
//		System.out.println("ReboardServiceImple: replyArticle ok");
		reboardDao.updateReply(reboardDto.getPseq());
//		System.out.println("ReboardServiceImple: updateReply ok");
		return reboardDto.getSeq();
	}

}
