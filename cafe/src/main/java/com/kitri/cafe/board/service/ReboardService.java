package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.ReboardDto;

public interface ReboardService {
	//일반게시판
	int writeArticle(ReboardDto reboardDto);
	List<ReboardDto> listArticle(Map<String, String> parameter);
	ReboardDto viewArticle(int seq);
	ReboardDto getArticle(int seq);
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
	
	//답장 게시판
	int replyArticle(ReboardDto reboardDto);
}
 