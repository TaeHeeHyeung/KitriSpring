package com.kitri.cafe.board.service;

import org.springframework.beans.factory.ListableBeanFactory;

import com.kitri.cafe.board.model.AlbumDto;
import java.util.*;


public interface AlbumService {
		
	int writeArticle(AlbumDto albumDto);
	List<AlbumDto> listArticle(Map<String, String> parameter);
	AlbumDto viewArticle(int seq);
	int modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
}
