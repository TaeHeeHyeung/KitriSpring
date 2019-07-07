package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.dao.MemoDao;
import com.kitri.cafe.board.model.MemoDto;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void writeMemo(MemoDto memoDto) {
		sqlSession.getMapper(MemoDao.class).writeMemo(memoDto);
	}

	@Override
	public String listMemo(int seq) {
		List<MemoDto> list = sqlSession.getMapper(MemoDao.class).listMemo(seq);
		JSONArray jsonArr = new JSONArray(list);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("memolist", jsonArr);
		return jsonObj.toString();
	}

	@Override
	public void modifyMemo(MemoDto memoDto) {
		// TODO Auto-generated method stub
	}

	@Override
	public String deleteMemo(int seq, int mseq) {
		sqlSession.getMapper(MemoDao.class).deleteMemo(mseq);
		List<MemoDto> list = sqlSession.getMapper(MemoDao.class).listMemo(seq);
		JSONArray jsonArr = new JSONArray(list);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("memolist", jsonArr);
		return jsonObj.toString();
	}
// shift +alt +m 	
//	String makeJson() {
//		
//	}

}
