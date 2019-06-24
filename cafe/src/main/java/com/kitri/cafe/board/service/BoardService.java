package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BbsDto;
import com.kitri.cafe.board.model.BoardDto;

public interface BoardService {
	int writeArticle(BoardDto boardDto);
	List<BbsDto> listArticle(Map<String, String> parameter);
	BbsDto viewArticle(int seq);
	int modifyArticle(BoardDto boardDto);
	void deleteArticle(int seq);
}
