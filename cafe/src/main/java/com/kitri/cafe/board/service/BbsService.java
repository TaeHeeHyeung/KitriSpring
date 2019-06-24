package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BbsDto;

public interface BbsService {
	int writeArticle(BbsDto BbsDto);
	List<BbsDto> listArticle(Map<String, String> parameter);
	BbsDto viewArticle(int seq);
	int modifyArticle(BbsDto BbsDto);
	void deleteArticle(int seq);
}
